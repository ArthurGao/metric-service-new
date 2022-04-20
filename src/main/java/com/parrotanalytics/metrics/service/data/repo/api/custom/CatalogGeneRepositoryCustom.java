package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.nonmanaged.GenreEntityCount;
import com.parrotanalytics.metrics.service.commons.constants.APICacheConstants;
import com.parrotanalytics.metrics.service.commons.constants.Entity;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

public interface CatalogGeneRepositoryCustom {

  @Cacheable(cacheNames = APICacheConstants.CACHE_EXPRESSIONS, keyGenerator = "cacheKeyGenerator")
  List<GenreEntityCount> getGenreEntityCount(Entity entity);
}
