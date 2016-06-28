package com.ljt.cxf;


import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Object saveInfo(@RequestBody Map<String,Object> reqData);
}
