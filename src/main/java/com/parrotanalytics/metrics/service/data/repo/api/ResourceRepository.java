package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Resource;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Raja 
 *
 */
@Repository
public interface ResourceRepository extends PagingAndSortingRepository<Resource, Integer>
{
	@Query("SELECT r FROM Resource r WHERE r.active = 1")
    public List<Resource> fetchResources();
	
	@Query("SELECT r FROM Resource r")
    public List<Resource> fetchAllResources();

    @Query("SELECT r FROM Resource r WHERE r.idResource = :idResource")
    public Resource fetchResource(@Param("idResource") Integer idResource);
}
