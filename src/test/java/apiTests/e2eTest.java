package apiTests;

import common.config.ConfigurationManager;
import layers.api.controllers.CustomerController;
import layers.api.controllers.IdentityController;
import layers.api.dto.accountDTO.AccountResponse;
import layers.api.dto.customer.accounts.AccountFilterDto;
import layers.api.dto.customer.accounts.AccountResponseDto;
import layers.api.models.Customer;
import layers.api.request.strategy.AuthStrategy;
import layers.api.request.strategy.AuthStrategyFactory;
import layers.data.UserFactory;
import org.junit.jupiter.api.Test;

public class e2eTest {
    @Test
    void transferTest(){
        AuthStrategy customerToken = AuthStrategyFactory.getStrategy("customer");

        IdentityController firstCustomer = new IdentityController(ConfigurationManager.getAppConfig().baseUrl(), customerToken);
        IdentityController secondCustomer = new IdentityController(ConfigurationManager.getAppConfig().baseUrl(), customerToken);
        CustomerController customerController = new CustomerController(ConfigurationManager.getAppConfig().baseUrl(), customerToken);
        Customer firstUser = UserFactory.generateCustomer();
        Customer secondUser = UserFactory.generateCustomer();
        firstCustomer.signupNewUser(firstUser);
        secondCustomer.signupNewUser(secondUser);

        AccountResponse firstAccount = customerController.postNewAccount(
                AccountResponse.builder()
                        .accountPlanId(1)
                        .currency(1)
                        .build()
        );

    }
}
