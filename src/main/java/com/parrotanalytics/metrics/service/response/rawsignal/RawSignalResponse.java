package com.parrotanalytics.metrics.service.response.rawsignal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parrotanalytics.metrics.service.response.parrotratings.DemandResponse;

import lombok.Data;

@Data
public class RawSignalResponse extends DemandResponse
{
    private static final long serialVersionUID = -625627087346443763L;

    @JsonProperty("source")
    private String source;

}