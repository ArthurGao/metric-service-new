package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Project;
import com.parrotanalytics.metrics.service.apidb_model.ProjectTimeSheet;
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
public interface TimeSheetRepository extends CrudRepository<ProjectTimeSheet, Integer>
{

    @Query("SELECT c FROM ProjectTimeSheet c WHERE c.project = :project")
    List<ProjectTimeSheet> loadByProject(@Param("project") Project project);
    
    @Query("SELECT c FROM ProjectTimeSheet c WHERE c.project = :project AND c.billable = 1")
    List<ProjectTimeSheet> loadBillableTimesheetByProject(@Param("project") Project project);

    @Query("SELECT c FROM ProjectTimeSheet c WHERE c.project = :project AND c.task = :task")
    ProjectTimeSheet loadByTimeSheetTask(@Param("project") Project project, @Param("task") String task);

}
