package com.demo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sites")
public class Api {

  @Inject
  private Sites sites = new Sites();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> info() {
    return sites.getSites();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String getSite(@PathParam("id") String id) {
    int index = Integer.parseInt(id);
    return sites.getSite(index);
  }

}