package s.core.dd.service.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import s.core.dd.model.*;
import s.core.dd.service.DdCoreService;

/** */
@Service("ddCoreService")
public class DdCoreServiceImpl implements DdCoreService {

  private static final Logger LOG = LoggerFactory.getLogger(DdCoreServiceImpl.class);

  @Autowired private Environment env;

  @Override
  public List<Account> getAccounts(ServiceRequestContext context) {
    LOG.info(env.getProperty("dd-service.log.message.key.1"));
    // TODO

    // TODO
    return null;
  }

  @Override
  public Account getAccount(long id, ServiceRequestContext context) {
    LOG.info(env.getProperty("dd-service.log.message.key.2"));
    // TODO

    // TODO
    return null;
  }
}
