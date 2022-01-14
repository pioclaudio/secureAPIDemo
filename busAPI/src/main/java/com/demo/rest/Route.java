package com.demo.rest;

public class Route {
  private int id;
  private String title;

  public Route() { }

  public Route(int id, String title) { 
    this.id = id;
    this.title = title;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }


}