package com.parrotanalytics.metrics.service.response.ingenreperformance;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class InGenrePerformance {

  private String genre;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Double percentile;
}
