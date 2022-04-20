package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Country;
import com.parrotanalytics.metrics.service.data.repo.api.custom.TalentsRepositoryCustom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 *
 * Extension of {@link PagingAndSortingRepository} & implementation of licensed
 * talents & their metadata to any of the REST API controllers.
 * 
 * 
 * @author Raja
 * @since v1
 *
 */
@Repository
@RepositoryRestResource(exported = false)
public interface TalentsRepository extends PagingAndSortingRepository<Country, String>, TalentsRepositoryCustom
{

}
