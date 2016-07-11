package com.ljt.cxf.impl;


import retrofit.Callback;
import retrofit.http.*;

import java.util.Map;

/**
 * @author lijuntao1
 * @date 2016/6/279:05
 */
public interface IService {
    @GET("/info/getinfo")
    Object getInfo();

    @POST("/info/saveinfo")
    void saveInfo(@Body Map<String, Object> reqData, Callback<Map<String, Object>> callback);

    @POST("/transportgame/save_transportgame")
    void saveTransportgamePayconfigInfo(@QueryMap Map<String, Object> reqData, Callback<Map<String, Object>> callback);
}
