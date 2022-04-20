package com.parrotanalytics.metrics.service.data.repo.api.cache;

import java.time.Duration;
import java.util.Map;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.util.StringUtils;

public class MetricRedisCacheManager extends RedisCacheManager {
  public MetricRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration, Map<String, RedisCacheConfiguration> initialCacheConfigurations) {
    super(cacheWriter, defaultCacheConfiguration);
  }

  @Override
  protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
    String[] array = StringUtils.delimitedListToStringArray(name, "#");
    name = array[0];
    if (array.length > 1) {
      long ttl = Long.parseLong(array[1]);
      cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(ttl));
    }
    return super.createRedisCache(name, cacheConfig);
  }

}
