package com.ljt.cxf;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by lijuntao1 on 2016/6/21.
 */
@Path("/")
public interface MyTestService {
    @GET
    @Path("/info/getinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getInfo();
}
