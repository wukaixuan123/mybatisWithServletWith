package com.hdax.pojo;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Workorder {

  private long id;
  private long projectId;
  private String executor;
  private String description;
  private long orderLevel;
  private java.util.Date createDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }


  public String getExecutor() {
    return executor;
  }

  public void setExecutor(String executor) {
    this.executor = executor;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getOrderLevel() {
    return orderLevel;
  }

  public void setOrderLevel(long orderLevel) {
    this.orderLevel = orderLevel;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-mm-dd");
    String date = simpleDateFormat.format(createDate);
    try {
      this.createDate = simpleDateFormat.parse(date);
      System.out.println(this.createDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
