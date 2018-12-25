package com.jsv.rest;
/*
 * User: Indika Gunawardana
 * Date: 12/25/18
 * Time: 6:25 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.model.Product;

import java.util.Date;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//http://localhost:8080/jsv/rest/json/product/get
@Path("/json/product")
public class ProductWS {
    @GET
    @Path("/get")
    @Produces("application/json")
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("iPad 3");
        product.setQty(999);

        return product;

    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Product product) {

        String result = "Product created : " + product;
        return Response.status(201).entity(result).build();

    }
}
