package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.application.core.domain.enums.EnumRifa;

public class Raffle {

  private Integer userId;

  private String raffleDate;

  private String description;

  private String title;
  private String value;

  private String imageName;

  private EnumRifa typeRaffle;

  private Integer pointQuantity;

  private Raffle() {
  }

  public static Raffle builder() {
    return new Raffle();
  }


  public Raffle userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  public Raffle raffleDate(String raffleDate) {
    this.raffleDate = raffleDate;
    return this;
  }

  public Raffle description(String description) {
    this.description = description;
    return this;
  }

  public Raffle title(String title) {
    this.title = title;
    return this;
  }

  public Raffle value(String value) {
    this.value = value;
    return this;
  }

  public Raffle imageName(String imageName) {
    this.imageName = imageName;
    return this;
  }

  public Raffle typeRaffle(EnumRifa typeRaffle) {
    this.typeRaffle = typeRaffle;
    return this;
  }

  public Raffle pointQuantity(Integer pointQuantity) {
    this.pointQuantity = pointQuantity;
    return this;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getRaffleDate() {
    return raffleDate;
  }

  public String getDescription() {
    return description;
  }

  public String getTitle() {
    return title;
  }

  public String getValue() {
    return value;
  }

  public String getImageName() {
    return imageName;
  }

  public EnumRifa getTypeRaffle() {
    return typeRaffle;
  }

  public Integer getPointQuantity() {
    return pointQuantity;
  }
}




