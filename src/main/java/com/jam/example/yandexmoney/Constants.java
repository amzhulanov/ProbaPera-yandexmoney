package com.jam.example.yandexmoney;


public class Constants {

    public static final String CLIENT_ID = "test_VU9HOcFAipLcHqj9NRKpDN_064NVO-nKB-7d7tY9X6E";
    public static final String REDIRECT_URI = "http://startandroid.ru";

    public static final String EXTRA_TOKEN = "token";
    public static final String EXTRA_ERROR = "error";
    public static final String EXTRA_URL = "url";
    public final static String API_URL = "https://payment.yandex.net/api/v3/";


    public final static String IDEMPOTENCE_KEY_HEADER = "Idempotence-Key";


    public final static int RETRIES_COUNT_MAX = 4;

    public final static int RETRIES_EXP_DELAY_INIT = 500;

    public final static int RETRIES_EXP_DELAY_MULTIPLIER = 2;

    public final static int RETRIES_DELAY_MAX = 10_000; //10sec


    private Constants() {}
}
