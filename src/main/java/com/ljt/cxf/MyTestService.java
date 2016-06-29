package com.ljt.cxf;


import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by lijuntao1 on 2016/6/21.
 */
@Path("/")
public interface MyTestService {
    @GET
    @Path("/info/getinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getInfo();

    @POST
    @Path("/info/saveinfo")
    @Consumes("application/json")
    @Produces("application/json")
    public Object saveInfo(Map<String,Object> reqData);

    @POST
    @Path("/info/saveinfo1")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object saveInfo1(@MatrixParam("reqData") String reqData);
}
