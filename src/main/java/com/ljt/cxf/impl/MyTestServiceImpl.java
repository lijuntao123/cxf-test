package com.ljt.cxf.impl;

import com.google.gson.Gson;
import com.ljt.cxf.MyTestService;
import com.sun.deploy.net.HttpResponse;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpRequest;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import java.util.Map;

/**
 * Created by lijuntao1 on 2016/6/21.
 */
public class MyTestServiceImpl implements MyTestService {

    public Object getInfo() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "zhangsan");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        return jsonObject.toString();
    }



    public Object saveInfo(Map<String,Object> reqData) {

        System.out.println("key = [" + new Gson().toJson(reqData) + "]");


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "zhangsan");
            jsonObject.put("name1", "lisi");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        return jsonObject.toString();
    }

    public Object saveInfo1(String reqData) {

        System.out.println("key = [" + reqData+ "]");


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "zhangsan");
            jsonObject.put("name1", "lisi");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        return jsonObject;
    }

    public Object saveInfo2(@FormParam("") String reqData) {
        return null;
    }
}
