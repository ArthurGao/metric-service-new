package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.InternalUser;
import com.parrotanalytics.metrics.service.apidb_model.PasswordResetLog;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Data repository for user account information.
 * 
 * @author jackson
 * @since v1
 */
@Repository
public interface PasswordResetLogRepository extends CrudRepository<PasswordResetLog, Integer>
{
    @Query("SELECT u FROM PasswordResetLog u " + "WHERE u.resetKey = :resetKey")
    public PasswordResetLog loadPasswordResetLogByKey(@Param("resetKey") String resetKey);

    @Query("SELECT u FROM PasswordResetLog u " + "WHERE u.user = :user")
    public List<PasswordResetLog> loadPasswordResetLogsByUser(@Param("user") InternalUser user);
}
