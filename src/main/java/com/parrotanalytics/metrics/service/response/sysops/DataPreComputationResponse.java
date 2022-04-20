package com.parrotanalytics.metrics.service.response.sysops;

import com.parrotanalytics.metrics.service.response.parrotratings.DemandResponse;

/**
 * @author Minh Vu
 */
public class DataPreComputationResponse extends DemandResponse
{

    private static final long serialVersionUID = -6817390240051120043L;

    private String markets;
    private String period;

    public String getPeriod()
    {
        return period;
    }

    public void setPeriod(String period)
    {
        this.period = period;
    }
}
