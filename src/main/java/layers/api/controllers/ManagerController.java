package layers.api.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import layers.api.dto.AccountPlansResponse;
import layers.api.dto.TransactionsResponse;
import layers.api.dto.blacklist.AccountLockDto;
import layers.api.dto.blacklist.AccountLocksResponse;
import layers.api.models.AccountPlan;
import layers.api.dto.CustomersResponse;

import layers.api.request.ApiRequest;
import layers.api.request.strategy.AuthStrategy;
import layers.api.utils.ObjectConverter;

import static layers.api.enums.Endpoints.*;

public class ManagerController extends ApiRequest {

//checking git fetch2
    public ManagerController(String URL, AuthStrategy token) {
        super(URL, token);
        this.URL = URL;
        requestSpecification = new RequestSpecBuilder()
                .setPort(7070)
                .setContentType(ContentType.JSON)
                .setBaseUri(this.URL)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token.getToken())
                .build();
    }

    public CustomersResponse getAllCustomers(){
        this.response = get(getEndpoint(MANAGER_API.getPath(), V1.getPath(), CUSTOMERS.getPath()));
        return this.response.as(CustomersResponse.class);
    }

    public Response deleteAccountCustomer(){
        this.response = delete(getEndpoint(MANAGER_API.getPath(), V1.getPath(), CUSTOMERS.getPath()));
        return this.response;
    }

    public AccountPlansResponse getAccountPlans(){
        this.response = get(getEndpoint(MANAGER_API.getPath(), V1.getPath(), ACCOUNT_PLANS.getPath()));
        return this.response.as(AccountPlansResponse.class);
    }

    public AccountPlan postAccountPlan(AccountPlan accountPlan){
        this.response = post(getEndpoint(MANAGER_API.getPath(), V1.getPath(), ACCOUNT_PLANS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(accountPlan));
                return this.response.as(AccountPlan.class);
    }

    public Response deleteAccountPlan(){
        this.response = delete(getEndpoint(MANAGER_API.getPath(), V1.getPath(), ACCOUNT_PLANS.getPath(), ID.getPath()));
        return this.response;
    }

    public AccountPlan updateAccountPlan(AccountPlan accountPlan){
        this.response = put(getEndpoint(MANAGER_API.getPath(), V1.getPath(), ACCOUNT_PLANS.getPath(), ID.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(accountPlan));
        return this.response.as(AccountPlan.class);
    }

    public AccountLocksResponse getLockedAccount(){
        this.response = get(getEndpoint(MANAGER_API.getPath(), V1.getPath(), BLACKLISTS.getPath()));
        return this.response.as(AccountLocksResponse.class);
    }

    public AccountLockDto postLockedAccount(AccountLockDto accountLockDto){
        this.response = post(getEndpoint(MANAGER_API.getPath(), V1.getPath(), BLACKLISTS.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(accountLockDto)
        );
        return this.response.as(AccountLockDto.class);
    }

    public TransactionsResponse getAllTransactions(){
        this.response = get(getEndpoint(MANAGER_API.getPath(), V1.getPath(), TRANSACTIONS.getPath()));
        return this.response.as(TransactionsResponse.class);
    }

}
