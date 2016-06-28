package com.ljt.cxf.impl;

import com.ljt.cxf.MyTestService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.Map;

/**
 * Created by lijuntao1 on 2016/6/21.
 */
public class MyTestServiceImpl implements MyTestService {

    public Object getInfo() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","zhangsan");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        return jsonObject.toString();
    }

    public Object saveInfo(Map<String,Object> reqData) {
        if(reqData!=null){
            for(String key:reqData.keySet()){
                System.out.println("key = [" + reqData.get(key) + "]");
            }
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","zhangsan");
            jsonObject.put("name1","lisi");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        return jsonObject.toString();
    }
}
