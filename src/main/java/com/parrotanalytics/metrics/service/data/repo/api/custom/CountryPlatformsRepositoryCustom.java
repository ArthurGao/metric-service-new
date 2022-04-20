package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.nonmanaged.ExtendedPlatformInfo;
import com.parrotanalytics.metrics.service.commons.constants.APICacheConstants;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryPlatformsRepositoryCustom
{
    @Cacheable(cacheNames = APICacheConstants.CACHE_PLATFORMS, key = "'pf:' + #clientReady")
    public List<ExtendedPlatformInfo> fetchPlatforms(int clientReady, List<String> catalogStates);

}
