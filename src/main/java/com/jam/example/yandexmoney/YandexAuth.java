package com.jam.example.yandexmoney;

import com.google.gwt.http.client.RequestBuilder;
import com.yandex.money.api.authorization.AuthorizationData;
import com.yandex.money.api.authorization.AuthorizationParameters;
import com.yandex.money.api.model.Scope;
import com.yandex.money.api.net.clients.ApiClient;
import com.yandex.money.api.net.clients.DefaultApiClient;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletionStage;

import static com.yandex.money.api.net.ApiRequest.Method.POST;


@Component
@Order(2)

public class YandexAuth {

    protected final String apiUrl;

    public YandexAuth(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public ApiClient createClient(){
        ApiClient client = new DefaultApiClient.Builder()
                .setClientId("your_client_id_here")
                .create();
        return client;
    }

    public void startAuthorization(int requestCode, Scope... scopes){

        AuthorizationParameters.Builder builder = new AuthorizationParameters.Builder()
                .setRedirectUri("https://client.example.com/cb");
        for (Scope scope : scopes) {
            builder.addScope(scope);
        }
        AuthorizationParameters parameters = builder.create();

        AuthorizationData data = AppController.getApiClient().createAuthorizationData(parameters);
        String url = data.getUrl() + "?" + new String(data.getParameters());

    }

    /**
     * Construct and execute POST request
     */
    protected <Rs> CompletionStage<Rs> post(String endpoint, String idempotenceKey,
                                            YandexCheckoutRequest rqModel, Class<Rs> resultType) {

        RequestBuilder rqBuilder = request(POST, apiUrl + endpoint)
                .addHeader(IDEMPOTENCE_KEY_HEADER, idempotenceKey);

        if (rqModel != null) {
            rqBuilder.setBody(mapper.write(rqModel));
        }

        return execute(rqBuilder.build(), idempotenceKey, resultType);
    }

}
