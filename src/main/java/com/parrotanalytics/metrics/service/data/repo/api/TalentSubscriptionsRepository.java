package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.TalentSubscription;
import com.parrotanalytics.metrics.service.data.repo.api.custom.SubscriptionsRepositoryCustom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Extension of {@link PagingAndSortingRepository} & implementation of {@link
 * SubscriptionsRepositoryCustom} to provide all the required data about licensed markets & content
 * titles to any of the REST API controllers.
 *
 * @author Nan Wu
 * @since v1
 */
@Repository
public interface TalentSubscriptionsRepository
    extends PagingAndSortingRepository<TalentSubscription, String> {

}
