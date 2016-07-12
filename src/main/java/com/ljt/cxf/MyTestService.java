package com.ljt.cxf;


import com.ljt.cxf.impl.MyTestServiceImpl;
import com.ljt.cxf.model.MyObj;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author lijuntao1
 * @date 2016/6/21 9:06
 */
@Path("/")
public interface MyTestService {
    @GET
    @Path("/info/getinfo")
    @Produces(MediaType.APPLICATION_JSON)//表示接受数据的类型，此处是server接收json类型数据
    Object getInfo();

    @POST
    @Path("/info/saveinfo")
    @Produces("application/json")
    @Consumes("application/json")//表示返回给调用者的数据类型，此处是json
    Object saveInfo(Map<String,Object> reqData);//http body 数据不用加注解

    @POST
    @Path("/info/saveinfo1")//@FormParam 注解的参数，必须以application/x-www-form-urlencoded 格式进行请求
    Object saveInfo1(@FormParam("name") String name,@FormParam("age") String age,@FormParam("address") String address);

    @POST
    @Path("/info/saveinfo2")
    @Produces("application/json")
    @Consumes("application/json")
    Object saveInfo2(MyObj reqData);

    @POST
    @Path("/info/saveinfo3")
    Object saveInfo3(@FormParam("") String reqData);

}
