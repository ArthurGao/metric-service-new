package com.parrotanalytics.metrics.service.data.repo.api.custom.impl;

import com.parrotanalytics.metrics.service.apidb_model.Label;
import com.parrotanalytics.metrics.service.data.repo.api.LabelRepository;
import com.parrotanalytics.metrics.service.data.repo.api.custom.LabelRepositoryCustom;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelRepositoryImpl implements LabelRepositoryCustom
{

    @Autowired
    private LabelRepository labelRepo;

    @Override
    public List<Long> filterShowsByLabels(List<String> labels, List<Long> filterShortIDs)
    {
        if (!CollectionUtils.isEmpty(labels))
        {
            List<Long> labelShortIDs = labelRepo.findTitlesWithLabels(labels).stream().map(Label::getShortId).distinct()
                    .collect(Collectors.toList());
            filterShortIDs = filterShortIDs.stream().filter(labelShortIDs::contains).collect(Collectors.toList());
        }

        return filterShortIDs;
    }

}
