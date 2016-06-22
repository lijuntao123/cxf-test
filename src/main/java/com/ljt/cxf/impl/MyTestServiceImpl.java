package com.ljt.cxf.impl;

import com.ljt.cxf.MyTestService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
        return jsonObject.toString();
    }
}
