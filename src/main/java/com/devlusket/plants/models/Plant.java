package com.devlusket.plants.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PLANTS")
public class Plant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="NAME")
  private String name;

  @Column(name="QUANTITY")
  private String quantity;

  @Column(name="WATERING_FREQUENCY")
  private String wateringFrequency;

  @Column(name="HAS_FRUIT")
  private Boolean hasFruit;


  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getWateringFrequency() {
    return wateringFrequency;
  }

  public void setWateringFrequency(String wateringFrequency) {
    this.wateringFrequency = wateringFrequency;
  }

  public Boolean getHasFruit() {
    return hasFruit;
  }

  public void setHasFruit(Boolean hasFruit) {
    this.hasFruit = hasFruit;
  }

}
