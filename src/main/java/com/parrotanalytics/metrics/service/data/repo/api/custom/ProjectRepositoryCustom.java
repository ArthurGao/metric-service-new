package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.Account;
import com.parrotanalytics.metrics.service.data.repo.api.MarketsRepository;
import com.parrotanalytics.metrics.service.response.project.ProjectResponse;
import com.parrotanalytics.apicore.exceptions.APIException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Interface for custom methods in {@link MarketsRepository}
 * 
 * @author Jackson
 * 
 */
public interface ProjectRepositoryCustom
{

    /**
     * 
     * @param accountID
     * @return
     * @throws ExecutionException
     */
    public List<ProjectResponse> injectProjectToResponseDemandPortal(Account account) throws APIException;

}
