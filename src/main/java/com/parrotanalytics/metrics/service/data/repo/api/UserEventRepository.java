package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.UserEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Minh Vu
 * @since v1
 */
@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Integer>
{

}
