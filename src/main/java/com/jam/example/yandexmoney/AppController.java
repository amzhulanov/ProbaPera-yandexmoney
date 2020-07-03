package com.jam.example.yandexmoney;

import com.yandex.money.api.net.clients.ApiClient;
import com.yandex.money.api.net.clients.DefaultApiClient;
import org.springframework.core.annotation.Order;

@Order(1)
public class AppController {

    public static final String PREFERENCES_FILE_NAME = "prefs";

    private static final ApiClient apiClient = new DefaultApiClient.Builder()
            .setClientId(Constants.CLIENT_ID).create();

    public static ApiClient getApiClient() {
        return apiClient;
    }




}
