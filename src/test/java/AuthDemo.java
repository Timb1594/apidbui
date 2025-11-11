import common.config.ConfigurationManager;
import layers.api.controllers.CustomerController;
import layers.api.controllers.IdentityController;
import layers.api.controllers.ManagerController;
import layers.api.dto.AccountPlansResponse;
import layers.api.dto.CustomersResponse;
import layers.api.dto.TransactionItemDto;
import layers.api.dto.TransactionsResponse;
import layers.api.dto.customer.accounts.AccountItemDto;
import layers.api.dto.customer.accounts.AccountResponseDto;
import layers.api.models.AccountPlan;
import layers.api.models.Customer;
import layers.api.request.ApiRequest;
import layers.api.request.strategy.AuthStrategy;
import layers.api.request.strategy.AuthStrategyFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AuthDemo {
    @Test
    void DemoTest() {
        AuthStrategy managerToken = AuthStrategyFactory.getStrategy("manager");

        ApiRequest apiRequest = new ApiRequest(ConfigurationManager.getAppConfig().baseUrl(), managerToken);

        given().spec(apiRequest.getRequestSpecification())
                .port(7070)
                .when()
                .get("/manager-api/v1/customers")
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();
    }

    @Test
    void demoTest2(){
        AuthStrategy managerToken = AuthStrategyFactory.getStrategy("manager");

        //ApiRequest apiRequest = new ApiRequest(ConfigurationManager.getAppConfig().baseUrl(), managerToken);

        IdentityController identityController = new IdentityController(ConfigurationManager.getAppConfig().baseUrl(), managerToken);

        ManagerController managerController = new ManagerController(ConfigurationManager.getAppConfig().baseUrl(), managerToken);

        CustomersResponse customersResponse = managerController.getAllCustomers();
        List<Customer> customers = customersResponse.getItems();
        for (Customer customer: customers){
            System.out.println(customer);
        }

        AccountPlansResponse accountPlansDto = managerController.getAccountPlans();
        System.out.println(accountPlansDto);
    }
    @Test
    void addAccountPlan(){
        AuthStrategy managerToken = AuthStrategyFactory.getStrategy("manager");
       // IdentityController identityController= new IdentityController(ConfigurationManager.getAppConfig().baseUrl(), managerToken);
        ManagerController managerController = new ManagerController(ConfigurationManager.getAppConfig().baseUrl(), managerToken);
        AccountPlan newPlan = AccountPlan.builder()
                .name("Argentum")
                .annualServicePrice(32.0)
                .build();
        AccountPlan createdPlan = managerController.postAccountPlan(newPlan);
    }

    @Test
    void addAccountToBlackList(){
        AuthStrategy managerToken = AuthStrategyFactory.getStrategy("manager");
        ManagerController managerController = new ManagerController(ConfigurationManager.getAppConfig().baseUrl(), managerToken);
        TransactionsResponse transactionsResponse = managerController.getAllTransactions();
        List<TransactionItemDto> transactions = transactionsResponse.getItems();
        for (TransactionItemDto transactionItemDto: transactions){
            System.out.println(transactionItemDto);
        }
    }

    @Test
    void getAccounts(){
        AuthStrategy customerToken = AuthStrategyFactory.getStrategy("customer");
        CustomerController customerController = new CustomerController(ConfigurationManager.getAppConfig().baseUrl(), customerToken);
        AccountResponseDto accountResponseDto = customerController.getAllAccounts();
        List<AccountItemDto> accounts = accountResponseDto.getItems();
        for(AccountItemDto account: accounts){
            System.out.println(account);
        }
    }
}