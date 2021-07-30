package com.hdax.pojo;


import java.util.List;

public class Project {

  private long id;
  private String projectName;
  private Workorder workorder;

  public Workorder getWorkorder() {
    return workorder;
  }

  public void setWorkorder(Workorder workorder) {
    this.workorder = workorder;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

}
