package com.jam.example.yandexmoney;

import com.yandex.money.api.model.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class RequestAuth implements ApplicationRunner {

    public static final int REQUEST_CODE_AUTH = 1;

    @Autowired
    YandexAuth yandexAuth;

//    private void requestAuthorization() {
//        yandexAuth.startAuthorization( REQUEST_CODE_AUTH, Scope.OPERATION_HISTORY, Scope.OPERATION_DETAILS);
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("start auth");
        yandexAuth.startAuthorization( REQUEST_CODE_AUTH, Scope.OPERATION_HISTORY, Scope.OPERATION_DETAILS);
    }
}
