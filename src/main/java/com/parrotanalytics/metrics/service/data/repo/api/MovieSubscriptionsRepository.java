package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.MovieSubscription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Minh Vu
 * @since v1
 */
@Repository
public interface MovieSubscriptionsRepository
    extends PagingAndSortingRepository<MovieSubscription, String> {

}
