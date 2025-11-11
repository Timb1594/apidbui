package layers.api.request.strategy;

import layers.api.request.LoginClient;

public class ManagerAuthStrategy implements AuthStrategy{
    @Override
    public String getToken() {
        return LoginClient.getToken("manager@nbwallet.com", "password");
    }
}
