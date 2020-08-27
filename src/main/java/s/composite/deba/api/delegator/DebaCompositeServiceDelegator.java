package s.composite.deba.api.delegator;

import com.cognizant.cosmos.core.utils.FutureUtils;
import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import s.composite.deba.api.IDebaCompositeService;
import s.composite.deba.api.helper.IDebaCompositeServiceHelper;

@Component
public class DebaCompositeServiceDelegator implements IDebaCompositeService {
  private static final Logger LOG = LoggerFactory.getLogger(DebaCompositeServiceDelegator.class);

  @Autowired private FutureUtils futureUtils;

  @Autowired private Environment env;

  @Autowired private IDebaCompositeServiceHelper debaCompositeServiceHelper;

  public ServiceResponseContext getAccounts(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    debaCompositeServiceHelper.processGetAccountsRequest(execution);
    return debaCompositeServiceHelper.processGetAccountsResponse(execution);
  }

  public ServiceResponseContext getAccount(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    debaCompositeServiceHelper.processGetAccountRequest(execution);
    return debaCompositeServiceHelper.processGetAccountResponse(execution);
  }
}
