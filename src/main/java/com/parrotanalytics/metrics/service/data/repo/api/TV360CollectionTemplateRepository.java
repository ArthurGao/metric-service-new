package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.TV360CollectionTemplate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author minhvu
 *
 */
public interface TV360CollectionTemplateRepository extends CrudRepository<TV360CollectionTemplate, Integer>
{
    public List<TV360CollectionTemplate> findByName(String name);
}
