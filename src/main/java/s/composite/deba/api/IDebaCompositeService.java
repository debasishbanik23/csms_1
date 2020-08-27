package s.composite.deba.api;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;

/** */
public interface IDebaCompositeService {

  ServiceResponseContext getAccounts(ServiceRequestContext context);

  ServiceResponseContext getAccount(ServiceRequestContext context);
}
