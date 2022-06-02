package com.cbt.cbt;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource
{
    @GET
    @Produces("text/plain")
    public String hello()
    {
        return "{\"name\" : \"Prateek\", \"age\" : \"36\"}";
    }

    @POST
    @Produces("text/plain")
    public String helloPost()
    {

        return "{\"name\" : \"Prateek\", \"age\" : \"36\"}";
    }
}