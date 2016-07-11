package com.ljt.cxf.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
                .acceptEncoding("UTF-8");
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

//        Form form=new Form();
//        form.param("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
//        form.param("packageName", "com.ljt.game");
//        form.param("applicationName", "11");
//        form.param("partnerName", "111");
//        form.param("appKey", "1");
//        form.param("appSecret", "2");
//        form.param("md5key", "3");

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "11");
        body.put("partnerName", "111");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");

        client.type("json").accept("json").encoding("utf-8").acceptEncoding("utf-8");
        String response = client.path("/info/saveinfo/").post(body.toString(),String.class);
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

        client.type("json").accept("json").encoding("utf-8").acceptEncoding("utf-8");
        String response = client.path("/info/saveinfo1/").post(new Gson().toJson(body),String.class);
        assertNotNull(response);
        System.out.println("testSaveInfo1 responseMessage : " + response);

    }
}