package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Country;
import com.parrotanalytics.metrics.service.data.repo.api.custom.MarketsRepositoryCustom;
import com.parrotanalytics.metrics.service.data.repo.api.custom.TitlesRepositoryCustom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 *
 * Extension of {@link PagingAndSortingRepository} & implementation of
 * {@link MarketsRepositoryCustom} to provide all the required data about
 * licensed titles & their metadata to any of the REST API controllers.
 * 
 * 
 * @author Sanjeev Sharma
 * @since v1
 *
 */
@Repository
@RepositoryRestResource(exported = false)
public interface TitlesRepository extends PagingAndSortingRepository<Country, String>, TitlesRepositoryCustom
{

}
