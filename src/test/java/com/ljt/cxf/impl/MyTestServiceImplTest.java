package com.ljt.cxf.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ljt.cxf.model.MyObj;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by lijuntao1 on 2016/6/23.
 */
public class MyTestServiceImplTest {

    private WebClient client;

    @Before
    public void setUp() throws Exception {
        String baseAddress = "http://localhost:8080/services/";
        client = WebClient.create(baseAddress)
                .header("charset", "UTF-8")
                .encoding("UTF-8")
                .acceptEncoding("UTF-8").accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void testGetInfo() {
        String responseMessage = client.path("info/getinfo")
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("testGetInfo responseMessage : " + responseMessage);
        assertNotEquals(responseMessage, null);
    }

    @Test
    public void testSaveInfo() {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "11");
        body.put("partnerName", "111");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");

        String response = client.accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON).encoding("UTF-8")
                .path("/info/saveinfo/").post(new Gson().toJson(body), String.class);
        assertNotNull(response);
        System.out.println("testSaveInfo responseMessage : " + response);

    }

    @Test
    public void testSaveInfo1() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "11");
        body.put("partnerName", "111");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");

        String response = client.type(MediaType.APPLICATION_FORM_URLENCODED).path("/info/saveinfo1/")
                .post(new Gson().toJson(body), String.class);
        assertNotNull(response);
        System.out.println("testSaveInfo1 responseMessage : " + response);

    }

    @Test
    public void testSaveInfo2() {
        MyObj myObj = new MyObj();
        myObj.setName("zhangsan");
        myObj.setAddress("ÇàµºÊÐ");
        myObj.setAge("12");
        String response = client.type(MediaType.APPLICATION_JSON)
                .encoding("UTF-8").path("/info/saveinfo2/")
                .post(new Gson().toJson(myObj), String.class);
        assertNotNull(response);
        System.out.println("testSaveInfo2 responseMessage : " + response);

    }
}