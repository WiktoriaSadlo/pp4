package ecommerce.payu;

public class AuthorizationResponse {
    String access_token;

    public AuthorizationResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getAccessToken() {
        return access_token;
    }
}
