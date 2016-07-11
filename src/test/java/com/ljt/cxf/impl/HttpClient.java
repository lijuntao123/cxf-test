package com.ljt.cxf.impl;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import org.apache.cxf.jaxrs.client.WebClient;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by lijuntao1 on 2016/6/27.
 */
public class HttpClient {

    private static WebClient client;
    private RestAdapter restAdapter;
//    private static String baseAddress = "http://10.18.210.141:8080/mgcoapi/";
    private static String baseAddress = "http://localhost:8080/services/";


    public static void main(String[] args) {
        client = WebClient.create(baseAddress)
                .header("charset", "UTF-8")
                .encoding("UTF-8")
                .acceptEncoding("UTF-8");
//       doGet();
        doPost1();
    }

    public static void doPost() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "��Ϸ");
        body.put("partnerName", "������");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");

        IService service=getRestAdapter().create(IService.class);
        service.saveTransportgamePayconfigInfo(body, new Callback<Map<String, Object>>() {
            public void success(Map<String, Object> stringObjectMap, Response response) {
                System.out.println("stringObjectMap = [" + stringObjectMap.toString() + "]");
            }

            public void failure(RetrofitError retrofitError) {
                System.out.println("retrofitError=" + retrofitError.getMessage());
            }
        });
    }

    public static void doPost1() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "��Ϸ");
        body.put("partnerName", "������");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");
        IService service=getRestAdapter().create(IService.class);
        service.saveInfo(body, new Callback<Map<String, Object>>() {
            public void success(Map<String, Object> stringObjectMap, Response response) {
                System.out.println("stringObjectMap = [" + stringObjectMap.toString() + "]");
            }

            public void failure(RetrofitError retrofitError) {
                retrofitError.fillInStackTrace().printStackTrace();
            }
        });
    }

    public static void doGet() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");

        String responseMsg = client.path("transportgame/get_transportgame_payconfig_info").
                replaceQueryParam("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7")
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("responseMsg=" + responseMsg);
    }

    public static RestAdapter getRestAdapter(){
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(15000, TimeUnit.MILLISECONDS);
        OkClient retrofitClient = new OkClient(client);

        return new RestAdapter.Builder()
                .setEndpoint(baseAddress).setClient(retrofitClient).setConverter(new GsonConverter(new Gson(),"UTF-8"))
                .build();

    }
}
