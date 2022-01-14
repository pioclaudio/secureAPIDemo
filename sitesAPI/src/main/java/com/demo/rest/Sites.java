package com.demo.rest;

import java.util.List;
import java.util.Arrays;

public class Sites {
  private List<String> siteList;

  public Sites() {
    String[] cities = {"Toronto", "Montreal", "Calgary", "Ottawa", "Edmonton"};
    this.siteList = Arrays.asList(cities);
  }

  public void setSites(List<String> siteList) {
    this.siteList = siteList;
  }

  public List<String> getSites() {
      return this.siteList;
  }

  public String getSite(int index) {
      return this.siteList.get(index);
  }
}