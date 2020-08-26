package s.core.dd.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import s.core.dd.dao.DdCoreDao;
import s.core.dd.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class DdCoreServiceTest {

  @Autowired private DdCoreService ddCoreService;
  @MockBean private DdCoreDao ddCoreDAO;

  @Test
  public void testGetAccounts() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetAccount() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
