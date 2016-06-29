package com.ljt.cxf.impl;


import retrofit.Callback;
import retrofit.http.*;

import java.util.Map;

/**
 * Created by lijuntao1 on 2016/6/27.
 */
public interface IService {
    @GET("/info/getinfo")
    public Object getInfo();

    @POST("/info/saveinfo")
    public void saveInfo(@Body Map<String,Object> reqData, Callback<Map<String,Object>> callback);

    @POST("/transportgame/save_transportgame")
    public void saveTransportgamePayconfigInfo(@QueryMap Map<String,Object> reqData, Callback<Map<String,Object>> callback);
}
