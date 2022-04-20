package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.nonmanaged.GroupedBreakdown;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface BreakdownRepositoryCustom
{
    public List<GroupedBreakdown> showDemandBreakdownAverageChange(List<Date> lastPeriodDateRange,
            List<Date> thisPeriodDateRange, List<String> marketsList, Long shortID, PageRequest pageRequest);

}
