package s.core.dd.api.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;

import s.core.dd.model.*;
import s.core.dd.service.DdCoreService;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/** */
@RestController
@Api("account-service")
public class DdCoreServiceController {

  private static final Logger LOG = LoggerFactory.getLogger(DdCoreServiceController.class);
  @Autowired private Environment env;
  @Autowired private DdCoreService ddCoreService;

  /** */
  @GetMapping(
      value = "/accounts",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Find all accounts", tags = "", response = Account.class)
  @ApiResponses({@ApiResponse(code = 200, message = "All accounts successfully returned")})
  public ResponseEntity<List<Account>> getAccounts(
      @ApiParam(value = "account holder", required = true)
          @RequestParam(value = "user", required = true)
          String user,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("dd-api.log.message.key.1"));
    List<Account> data =
        ddCoreService.getAccounts(new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data) && !data.isEmpty()) {
      LOG.info(env.getProperty("dd-api.log.message.key.2"));
      return new ResponseEntity<List<Account>>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("dd-api.log.message.key.3"));
      return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @GetMapping(
      value = "/accounts/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Find account by ID", tags = "", response = Account.class)
  @ApiResponses({@ApiResponse(code = 200, message = "account successfully returned")})
  public ResponseEntity<Account> getAccount(
      @ApiParam(value = "The ID of the account", required = true)
          @PathVariable(value = "id", required = true)
          long id,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("dd-api.log.message.key.4"));
    Account data =
        ddCoreService.getAccount(id, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("dd-api.log.message.key.2"));
      return new ResponseEntity<Account>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("dd-api.log.message.key.3"));
      return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }
  }
}
