package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.LiveAffinityIndex;
import com.parrotanalytics.metrics.service.apidb_model.LiveDatasourceMetrics;
import com.parrotanalytics.metrics.service.commons.constants.Entity;
import java.util.List;

public interface ContextMetricRepositoryCustom
{
    public List<LiveAffinityIndex> getLiveAffinityIndex(List<Long> shortIDFroms, Entity entity);

    public List<LiveDatasourceMetrics> getLiveDataSourceMetrics(List<Long> shortIDs, Entity entity);

}
