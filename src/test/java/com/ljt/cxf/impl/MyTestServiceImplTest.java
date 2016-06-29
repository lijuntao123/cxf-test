package com.ljt.cxf.impl;

import com.google.gson.Gson;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.InvocationCallback;
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
    private String baseAddress = "http://localhost:8080/services/";

    @Before
    public void setUp() throws Exception {
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
        System.out.println("responseMessage : " + responseMessage);
        assertNotEquals(responseMessage, null);
    }

    @Test
    public void testSaveInfo() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("accessToken", "TI8DTPRXQ9ZHMM1N4JEJ401CXPDE0DF7");
        body.put("packageName", "com.ljt.game");
        body.put("applicationName", "ÓÎÏ·");
        body.put("partnerName", "Àõ¾üÌÎ");
        body.put("appKey", "1");
        body.put("appSecret", "2");
        body.put("md5key", "3");

        client.type("json").accept("json").encoding("utf-8");
        Response response = client.path("/info/saveinfo/").post(new Gson().toJson(body));
        assertNotNull(response);
        System.out.println("responseMessage : " + response.getMetadata());

    }


}