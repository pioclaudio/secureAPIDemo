package com.demo.rest;

import java.util.List;
import java.util.ArrayList;

public class Routes {
  private List<Route> routeList;

  public Routes() {
    this.routeList = new ArrayList<Route>();
    this.routeList.add(new Route(7, "7-Bathurst"));
    this.routeList.add(new Route(8, "8-Broadview"));
    this.routeList.add(new Route(9, "9-Bellamy"));
    this.routeList.add(new Route(10, "10-Van Horne"));
    this.routeList.add(new Route(11, "11-Bayview"));
    this.routeList.add(new Route(12, "12-Kingston Road"));
    this.routeList.add(new Route(13, "13-Avenue Road"));
  }

  public void setRoutes(List<Route> routeList) {
    this.routeList = routeList;
  }

  public List<Route> getRoutes() {
    return this.routeList;
  }

  public Route getRoute(int index) {
    return this.routeList.get(index);
  }
}