package layers.api.controllers;

import common.config.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import layers.api.models.Customer;
import layers.api.models.Token;
import layers.api.request.ApiRequest;
import layers.api.request.strategy.AuthStrategy;
import layers.api.utils.ObjectConverter;

import java.util.HashMap;
import java.util.Map;

import static layers.api.enums.Endpoints.*;

public class IdentityController extends ApiRequest {
// checking git fetch
    //checking git fetch second time
    private static final String BASE_URL = ConfigurationManager.getAppConfig().baseUrl();
    public IdentityController(String URL, AuthStrategy token) {
        super(URL, token);
        this.URL = URL;
        requestSpecification = new RequestSpecBuilder()
                .setPort(5050)
                .setContentType(ContentType.MULTIPART)
                .setBaseUri(this.URL)
                .setAccept(ContentType.JSON)
                .build();
    }

//    public String getToken(Token token){
//        this.response = post(getEndpoint(API.getPath(), V1.getPath(),AUTHENTICATION.getPath(), LOGIN.getPath()),
//                ObjectConverter.convertJavaObjectToJsonObject(token));
//        return token.getJwtToken();
//    }

    public Response signupNewUser(Customer customer){
        Map<String, Object> formData = new HashMap<>();
        formData.put("FirstName", customer.getFirstName());
        formData.put("LastName", customer.getLastName());
        formData.put("Email", customer.getEmail());
        formData.put("Password", customer.getPassword());
        formData.put("PhoneNumber", customer.getPhoneNumber());
        this.response = post(getEndpoint(API.getPath(),V1.getPath(),AUTHENTICATION.getPath(),SIGN_UP.getPath()), formData);
        return this.response;
    }

    public Response refreshToken(Token token){
        this.response = post(getEndpoint(API.getPath(), V1.getPath(), AUTHENTICATION.getPath(), REFRESH.getPath()),
                ObjectConverter.convertJavaObjectToJsonObject(token.getRefreshToken()));
        return this.response;
    }

}
