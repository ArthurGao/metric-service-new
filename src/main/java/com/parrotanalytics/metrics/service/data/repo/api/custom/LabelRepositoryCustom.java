package com.parrotanalytics.metrics.service.data.repo.api.custom;

import java.util.List;

public interface LabelRepositoryCustom
{
    List<Long> filterShowsByLabels(List<String> labels, List<Long> filterShortIDs);
}
