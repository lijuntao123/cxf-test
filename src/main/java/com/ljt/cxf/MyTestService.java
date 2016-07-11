package com.ljt.cxf;


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
    @Produces(MediaType.APPLICATION_JSON)
    Object getInfo();

    @POST
    @Path("/info/saveinfo")
    @Produces("application/json")
    Object saveInfo(@RequestBody Map<String,Object> reqData);

    @POST
    @Path("/info/saveinfo1")
    @Produces(MediaType.APPLICATION_JSON)
    Object saveInfo1(@FormParam("") String reqData);

    @POST
    @Path("/info/saveinfo2")
    @Produces(MediaType.APPLICATION_JSON)
    Object saveInfo2(@FormParam("") String reqData);
}
