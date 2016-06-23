package com.ljt.cxf.impl;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertNotEquals;


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
    public void testGetInfo(){
        String responseMessage = client.path("info/getinfo")
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("responseMessage : " + responseMessage);
        assertNotEquals(responseMessage, null);
    }


}