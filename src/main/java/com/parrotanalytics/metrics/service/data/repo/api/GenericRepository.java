package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for Generic Data Queries
 * 
 * @author sanjeev
 *
 */
@Repository
@RepositoryRestResource(exported = false)
public interface GenericRepository extends PagingAndSortingRepository<Resource, Integer>
{
}
