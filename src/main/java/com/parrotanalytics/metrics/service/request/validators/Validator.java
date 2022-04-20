package com.parrotanalytics.metrics.service.request.validators;

import com.parrotanalytics.apicore.exceptions.APIException;

public interface Validator<REQ, RESP> {
  RESP validateCall(REQ request) throws APIException;
}
