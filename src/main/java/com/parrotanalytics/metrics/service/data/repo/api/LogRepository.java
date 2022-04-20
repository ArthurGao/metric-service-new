package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.UserLog;
import com.parrotanalytics.metrics.service.data.repo.api.custom.LogRepositoryCustom;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Sanjeev Sharma, Minh Vu
 * @since v1
 *
 */
@Repository
public interface LogRepository extends PagingAndSortingRepository<UserLog, String>, LogRepositoryCustom
{
    @Query("SELECT l from UserLog l where l.userId=:userId")
    public List<UserLog> findUserLogs(@Param("userId") Integer userId, Pageable page);
}
