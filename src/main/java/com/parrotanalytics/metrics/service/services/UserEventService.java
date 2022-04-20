package com.parrotanalytics.metrics.service.services;

import com.parrotanalytics.metrics.service.apidb_model.InternalUser;
import com.parrotanalytics.metrics.service.apidb_model.UserEvent;
import com.parrotanalytics.metrics.service.data.repo.api.UserEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventService
{
    @Autowired
    private UserEventRepository userEventRepo;

    public UserEvent addCustomerAPIUserEvent(InternalUser user, UserEvent userEvent)
    {
        if (user != null)
            userEvent.setUserId(user.getIdUser());
        return userEventRepo.save(userEvent);
    }

}