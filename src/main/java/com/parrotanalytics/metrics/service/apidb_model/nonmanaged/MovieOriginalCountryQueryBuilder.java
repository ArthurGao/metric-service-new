package com.parrotanalytics.metrics.service.apidb_model.nonmanaged;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.parboiled.common.StringUtils;

@Data
public class MovieOriginalCountryQueryBuilder {

  private StringInputFilter filter;
  private static String NESTED_FIELD = "value";
  private static String ORDINAL_NESTED_FIELD = "ordinal";
  private static String PATH = "data.original_country";

  public MovieOriginalCountryQueryBuilder(StringInputFilter filter) {
    this.filter = filter;
  }

  public QueryBuilder buildQuery() {
    BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

    String fullPath = PATH + "." + NESTED_FIELD;
    String fullOrdinalPath = PATH + "." + ORDINAL_NESTED_FIELD;
    if (StringUtils.isNotEmpty(filter.getEq())) {
      BoolQueryBuilder nestedBoolQuery = QueryBuilders.boolQuery();

      nestedBoolQuery.must().add(QueryBuilders.matchQuery(fullOrdinalPath, 0));
      nestedBoolQuery.must().add(QueryBuilders.termQuery(fullPath, filter.getEq()));

      NestedQueryBuilder nestedQuery = QueryBuilders.nestedQuery(PATH, nestedBoolQuery,
          ScoreMode.Avg);

      boolQuery.must()
          .add(nestedQuery);
    }

    if (StringUtils.isNotEmpty(filter.getNe())) {
      BoolQueryBuilder nestedBoolQuery = QueryBuilders.boolQuery();

      nestedBoolQuery.mustNot().add(QueryBuilders.matchQuery(fullOrdinalPath, 0));
      nestedBoolQuery.mustNot().add(QueryBuilders.termQuery(fullPath, filter.getNe()));

      NestedQueryBuilder nestedQuery = QueryBuilders.nestedQuery(PATH, nestedBoolQuery,
          ScoreMode.Avg);

      boolQuery.mustNot().add(nestedQuery);
    }

    if (CollectionUtils.isNotEmpty(filter.getIn())) {

      BoolQueryBuilder nestedBoolQuery = QueryBuilders.boolQuery();

      nestedBoolQuery.must().add(QueryBuilders.matchQuery(fullOrdinalPath, 0));
      nestedBoolQuery.must().add(QueryBuilders.termsQuery(fullPath, filter.getIn()));

      NestedQueryBuilder nestedQuery = QueryBuilders.nestedQuery(PATH, nestedBoolQuery,
          ScoreMode.Avg);

      boolQuery.must()
          .add(nestedQuery);
    }

    return boolQuery;
  }
}
