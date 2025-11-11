package layers.api.request.strategy;

import layers.api.request.LoginClient;

public class CustomerAuthStrategy implements AuthStrategy {

    @Override
    public String getToken() {
        return LoginClient.getToken("timb1594@gmail.com", "21122012Tt@");
    }
}
