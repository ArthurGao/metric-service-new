package com.parrotanalytics.metrics.service.grpc.services;


import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.parrotanalytics.apicore.model.catalogapi.metadata.CatalogItem;
import com.parrotanalytics.metrics.commons.Interval;
import com.parrotanalytics.metrics.commons.MetricType;
import com.parrotanalytics.metrics.commons.Order;
import com.parrotanalytics.metrics.commons.OverallDemandRequest;
import com.parrotanalytics.metrics.commons.OverallDemandResponse;
import com.parrotanalytics.metrics.commons.OverallDemandResponse.DemandData;
import com.parrotanalytics.metrics.commons.OverallDemandResponse.DemandData.Builder;
import com.parrotanalytics.metrics.commons.OverallDemandServiceGrpc;
import com.parrotanalytics.metrics.commons.Query;
import com.parrotanalytics.metrics.service.apidb_model.nonmanaged.GroupedExpressions;
import com.parrotanalytics.metrics.service.data.repo.api.cache.MetadataCache;
import com.parrotanalytics.metrics.service.request.demand.DataQuery;
import com.parrotanalytics.metrics.service.request.demand.DemandRequest;
import com.parrotanalytics.metrics.service.services.DemandService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import net.devh.boot.grpc.server.service.GrpcService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@GrpcService
public class OverallDemandGrpcService extends OverallDemandServiceGrpc.OverallDemandServiceImplBase {

    protected static Logger logger = LoggerFactory.getLogger(OverallDemandGrpcService.class);

    @Autowired
    private DemandService demandService;

    @Autowired
    private MetadataCache metadataCache;

    @Override
    public void getOverallDemand(OverallDemandRequest request, StreamObserver<OverallDemandResponse> responseObserver) {

        int page = request.getPage();
        MetricType metricType = request.getMetricType();
        Interval interval = request.getInterval();
        MetricType sortBy = request.getSortBy();
        Order order = request.getOrder();
        int size = request.getSize();
        List<Query> queryList = request.getQueryList();

        OverallDemandResponse.Builder responseBuilder = OverallDemandResponse.newBuilder();
        List<GroupedExpressions> results = new ArrayList<>();
        try {
            for(Query query : queryList) {
                DemandRequest apiRequest = new DemandRequest();
                apiRequest.setMetricType(metricType.toString());
                apiRequest.setInterval(interval.toString());
                DataQuery dataQuery = new DataQuery();
                dataQuery.setEntity(query.getEntity().toString());
                dataQuery.setListMarkets(Arrays.asList(query.getMarkets()));
                dataQuery.setDateFrom(new DateTime(Timestamps.toMillis(query.getDateFrom())));
                dataQuery.setDateTo(new DateTime(Timestamps.toMillis(query.getDateTo())));

                dataQuery.setDateRangeList(Arrays.asList(
                    new Date(Timestamps.toMillis(query.getDateFrom())), new Date(Timestamps.toMillis(query.getDateTo()))));
                dataQuery.setPeriod(query.getPeriod().toString().replace("_", "-"));
                dataQuery.setContent(query.getContent());

                apiRequest.setQuery(Arrays.asList(dataQuery));

                Sort sort = (order.equals(Order.ASC)) ? Sort.by(sortBy.toString()).ascending()
                    : Sort.by(sortBy.toString()).descending();
                PageRequest pageRequest = PageRequest.of(page, size, sort);
                demandService.parseTime(apiRequest, dataQuery, null);
                demandService.parseContent(dataQuery, apiRequest, null);
                results.addAll(demandService.showsOverallDemandByDateRange(apiRequest, pageRequest));
            }

            Builder dataBuilder;
            for(GroupedExpressions groupedExpressions : results){
                dataBuilder = DemandData.newBuilder();
                dataBuilder.setMarket(groupedExpressions.getCountry());
                dataBuilder.setOverallRank(groupedExpressions.getOverall_rank());
                dataBuilder.setValue(getValueByMetricType(groupedExpressions, metricType));

                long dateSeconds = groupedExpressions.getDate().getTime();
                Timestamp timeStamp = Timestamp.newBuilder().setSeconds(dateSeconds / 1000)
                    .setNanos((int) ((dateSeconds % 1000) * 1000000)).build();
                dataBuilder.setDate(timeStamp);

                CatalogItem metaData = metadataCache.resolveItem(groupedExpressions.getShort_id());
                dataBuilder.setLabel(metaData.getDisplayName());
                dataBuilder.setParrotId(metaData.getParrotID());

                responseBuilder.addData(dataBuilder.build());
            }
        } catch (Exception e) {
            logger.error("Failed to do my remote operation", e);
            responseObserver.onError(Status.INTERNAL
                .withDescription(e.getMessage())
                .withCause(e) // This is used locally only and NOT transmitted to the client!
                .asRuntimeException());
        }

        OverallDemandResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String getValueByMetricType(GroupedExpressions groupedExpressions, MetricType metricType){
        switch (metricType) {
            case dex:
                return Double.toString(groupedExpressions.getDex());
            case dexpercapita:
                return Double.toString(groupedExpressions.getDexpercapita());
            case peak_dex:
                return Double.toString(groupedExpressions.getPeak_dex());
            case peak_dexpercapita:
                return Double.toString(groupedExpressions.getPeak_dexpercapita());
            default:
                return null;
        }
    }

}
