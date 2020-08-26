package s.core.dd.service;

import java.util.*;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import s.core.dd.model.*;

public interface IDdCoreService {

  List<Account> getAccounts(ServiceRequestContext context);

  Account getAccount(long id, ServiceRequestContext context);
}
