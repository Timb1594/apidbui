package layers.api.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import layers.api.dto.TransactionItemDto;
import layers.api.dto.TransactionsResponse;
import layers.api.dto.accountDTO.AccountResponse;
import layers.api.dto.customer.accountPlans.AccountPlanResponseDto;
import layers.api.dto.customer.accounts.AccountFilterDto;
import layers.api.dto.customer.accounts.AccountResponseDto;
import layers.api.dto.customer.accounts.AccountTransactionLimitDto;
import layers.api.dto.customer.customer.CustomerUpdateInfoDto;
import layers.api.dto.customer.customer.UserResponseDto;
import layers.api.dto.customer.transfer.AccountTransferDto;
import layers.api.request.ApiRequest;
import layers.api.request.strategy.AuthStrategy;
import layers.api.utils.ObjectConverter;

import static layers.api.enums.Endpoints.*;

//checking git fetch
public class CustomerController extends ApiRequest {
    public CustomerController(String URL, AuthStrategy token) {
        super(URL, token);
        this.URL = URL;
        requestSpecification = new RequestSpecBuilder()
                .setPort(6060)
                .setContentType(ContentType.JSON)
                .setBaseUri(URL)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer "+token.getToken())
                .build();
    }

    //checking git
    public AccountResponseDto getAllAccounts(){
        this.response = get(getEndpoint(API.getPath(),V1.getPath(), ACCOUNT.getPath()));
        return this.response.as(AccountResponseDto.class);
    }

    public AccountResponse postNewAccount(AccountResponse accountResponse){
        this.response = post(getEndpoint(API.getPath(), V1.getPath(),ACCOUNT.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(accountResponse));
        return this.response.as(AccountResponse.class);
    }

    public AccountPlanResponseDto getAllAccountPlans(){
        this.response = get(getEndpoint(API.getPath(), V1.getPath(), ACCOUNT_PLANS.getPath()));
        return this.response.as(AccountPlanResponseDto.class);
    }

    public AccountTransactionLimitDto postNewTransactionLimit(AccountTransactionLimitDto limit){
        this.response = post(getEndpoint(API.getPath(), V1.getPath(), ACCOUNT_TRANSACTION_LIMITS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(limit));
        return this.response.as(AccountTransactionLimitDto.class);
    }

    public AccountTransactionLimitDto getTransactionLimitInfo(){
        this.response = get(getEndpoint(API.getPath(), V1.getPath(), ACCOUNT_TRANSACTION_LIMITS.getPath()));
        return this.response.as(AccountTransactionLimitDto.class);
    }

    public AccountTransactionLimitDto updateNewTransactionLimit(AccountTransactionLimitDto limit){
        this.response = put(getEndpoint(API.getPath(), V1.getPath(), ACCOUNT_TRANSACTION_LIMITS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(limit));
        return this.response.as(AccountTransactionLimitDto.class);
    }

    public void deleteTransactionLimit(int id){
        this.response = delete(getEndpoint(API.getPath(), V1.getPath(), ACCOUNT_TRANSACTION_LIMITS.getPath(), String.valueOf(id)));
    }

    public UserResponseDto updateCustomerInfo(CustomerUpdateInfoDto customerInfo){
        this.response = put(getEndpoint(API.getPath(), V1.getPath(), CUSTOMERS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(customerInfo));
        return this.response.as(UserResponseDto.class);
    }

    public Response deleteCustomer() {
        this.response = delete(getEndpoint(API.getPath(), V1.getPath(), CUSTOMERS.getPath()));
        return this.response;
    }

    public TransactionsResponse createNewTransaction(AccountTransferDto accountTransferDto){
        this.response = post(getEndpoint(API.getPath(), V1.getPath(), TRANSACTIONS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(accountTransferDto));
        return this.response.as(TransactionsResponse.class);
    }

    public TransactionItemDto getAllTransactions(){
        this.response = get(getEndpoint(API.getPath(), V1.getPath(), TRANSACTIONS.getPath()));
        return this.response.as(TransactionItemDto.class);
    }

}
