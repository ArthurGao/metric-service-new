package com.parrotanalytics.metrics.service.data.repo.api.custom.impl;

import com.parrotanalytics.metrics.service.apidb_model.Account;
import com.parrotanalytics.metrics.service.apidb_model.Project;
import com.parrotanalytics.metrics.service.apidb_model.ProjectTimeSheet;
import com.parrotanalytics.metrics.service.data.repo.api.ProjectRepository;
import com.parrotanalytics.metrics.service.data.repo.api.TimeSheetRepository;
import com.parrotanalytics.metrics.service.data.repo.api.custom.ProjectRepositoryCustom;
import com.parrotanalytics.metrics.service.response.project.ProjectResponse;
import com.parrotanalytics.apicore.exceptions.APIException;
import com.parrotanalytics.commons.utils.date.CommonsDateUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Jackson
 *
 */
public class ProjectRepositoryImpl implements ProjectRepositoryCustom
{

    @Autowired
    private TimeSheetRepository timeSheetRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public List<ProjectResponse> injectProjectToResponseDemandPortal(Account account) throws APIException
    {
        List<ProjectResponse> projectsResponse = new ArrayList<ProjectResponse>();
        List<Project> listProjects = projectRepo.loadCompletedProjectsByAccount(account);

        if (!listProjects.isEmpty() || null != listProjects)
        {
            for (Project project : listProjects)
            {
                ProjectResponse projectResponse = new ProjectResponse();
                projectResponse.setIdProject(project.getIdProject());
                projectResponse.setSponsor(project.getSponsor());
                projectResponse.setProjectName(project.getProjectName());
                projectResponse.setSponsored(project.getSponsored());
                projectResponse.setDeliveredDate(CommonsDateUtil.formatDate(project.getDeliveredDate()));
                List<ProjectTimeSheet> timesheets = timeSheetRepo.loadBillableTimesheetByProject(project);
                double projectHours = 0;
                if (null != timesheets)
                {
                    for (ProjectTimeSheet timesheet : timesheets)
                    {
                        projectHours += timesheet.getHours();
                    }
                }
                projectResponse.setProjectHours(projectHours);
                projectsResponse.add(projectResponse);
            }
        }
        return projectsResponse;
    }
}
