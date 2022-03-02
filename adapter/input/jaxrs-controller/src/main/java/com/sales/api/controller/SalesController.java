package com.sales.api.controller;

import com.sales.api.domain.exception.SalesException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sales")
@Produces(MediaType.APPLICATION_JSON)
public class SalesController {

    @GET
    @Path("/{id}")
    public Response findAll(@PathParam("id") String test) throws SalesException {
        return Response.ok(test).build();
    }
}
