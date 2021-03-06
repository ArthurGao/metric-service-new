package com.parrotanalytics.metrics.service.request.decorators;

import com.parrotanalytics.apicore.exceptions.APIException;

public interface Decorator<REQ> {
  void decorateRequest(REQ request) throws APIException;
}
