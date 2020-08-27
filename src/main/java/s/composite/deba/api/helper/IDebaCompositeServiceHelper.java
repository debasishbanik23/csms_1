package s.composite.deba.api.helper;

import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;

public interface IDebaCompositeServiceHelper {

  public void processGetAccountsRequest(ServiceExecution execution);

  public ServiceResponseContext processGetAccountsResponse(ServiceExecution execution);

  public void processGetAccountRequest(ServiceExecution execution);

  public ServiceResponseContext processGetAccountResponse(ServiceExecution execution);
}
