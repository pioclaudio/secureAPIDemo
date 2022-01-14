package com.demo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/routes")
public class Api {

  // @GET
  // @Produces(MediaType.TEXT_PLAIN)
  // public String info() {
  //   return "hello microservice";
  // }
  @Inject
  private Routes routes = new Routes();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Route> info() {
    return routes.getRoutes();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Route getRoute(@PathParam("id") String id) {
    int index = Integer.parseInt(id);
    return routes.getRoute(index);
  }

}