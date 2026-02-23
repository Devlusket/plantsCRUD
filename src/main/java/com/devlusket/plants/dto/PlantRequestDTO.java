package com.devlusket.plants.dto;

public class PlantRequestDTO {

  private String name;
  private Integer quantity;
  private String wateringFrequency;
  private Boolean hasFruit;
  private String accessPassword;

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public Integer getQuantity() {return quantity;}
  public void setQuantity(Integer quantity) {this.quantity = quantity;}

  public String getWateringFrequency() {return wateringFrequency;}
  public void setWateringFrequency(String wateringFrequency) {this.wateringFrequency = wateringFrequency;}

  public Boolean getHasFruit() {return hasFruit;}
  public void setHasFruit(Boolean hasFruit) {this.hasFruit = hasFruit;}

  public String getAccessPassword() {return accessPassword;}
  public void setAccessPassword(String accessPassword) {this.accessPassword = accessPassword;}

}
