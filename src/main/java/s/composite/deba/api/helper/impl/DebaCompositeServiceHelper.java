package s.composite.deba.api.helper.impl;

import java.util.*;

import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import s.composite.deba.api.helper.IDebaCompositeServiceHelper;
import s.composite.deba.model.*;

@Component
public class DebaCompositeServiceHelper implements IDebaCompositeServiceHelper {

  private static final Logger LOG = LoggerFactory.getLogger(DebaCompositeServiceHelper.class);

  @Autowired private ModelMapper modelMapper;

  @Autowired private ObjectMapper objectMapper;

  @Override
  public void processGetAccountsRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processGetAccountsResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processGetAccountRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processGetAccountResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }
}
