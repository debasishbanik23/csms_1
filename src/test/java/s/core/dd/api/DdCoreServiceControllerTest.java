package s.core.dd.api;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import s.core.dd.api.controller.DdCoreServiceController;
import s.core.dd.model.Account;
import s.core.dd.model.Customer;
import s.core.dd.model.AccountType;
import s.core.dd.service.DdCoreService;

@RunWith(SpringRunner.class)
@WebMvcTest(DdCoreServiceController.class)
@PropertySource("classpath:log.messages")
public class DdCoreServiceControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private DdCoreService ddCoreService;
  private ObjectMapper mapper = new ObjectMapper();

  private static final Object DEFAULT_RETURN = 1;

  private static final int DEFAULT_ID = 111;
  private static final String DEFAULT_NUMBER = "number";
  private static final AccountType DEFAULT_TYPE = null;
  private static final double DEFAULT_BALANCE = 111.10;
  private static final Customer DEFAULT_CUSTOMER = null;
  private static final String DEFAULT_ALLOW_SCHEDULED_TRANSACTIONS = "allow_scheduled_transactions";

  private Account defaultAccount() {
    Account account = new Account();
    account.setId(DEFAULT_ID);
    account.setNumber(DEFAULT_NUMBER);
    account.setType(DEFAULT_TYPE);
    account.setBalance(DEFAULT_BALANCE);
    account.setCustomer(DEFAULT_CUSTOMER);
    account.setAllowScheduledTransactions(DEFAULT_ALLOW_SCHEDULED_TRANSACTIONS);
    return account;
  }

  @Test
  public void testGetAccounts() throws Exception {
    Mockito.when(ddCoreService.getAccounts(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(Arrays.asList(defaultAccount()));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/accounts")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("user", "abc"))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testGetAccount() throws Exception {
    Mockito.when(
            ddCoreService.getAccount(
                Mockito.any(long.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultAccount());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/accounts/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }
}
