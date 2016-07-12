package com.ljt.cxf.impl;

import com.google.gson.Gson;
import com.ljt.cxf.MyTestService;
import com.ljt.cxf.model.MyObj;
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

        System.out.println("saveInfo key = [" + new Gson().toJson(reqData) + "]");


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

    public Object saveInfo1(String name,String age,String address) {

        System.out.println("saveInfo1 key = [" + name+ "]");


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

    public Object saveInfo2(MyObj reqData) {

        System.out.println("saveInfo2 key = [" + new Gson().toJson(reqData) + "]");


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

    public Object saveInfo3(String reqData) {

        System.out.println("saveInfo1 key = [" + reqData+ "]");


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
}
