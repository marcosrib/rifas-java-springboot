package com.rifas.trevorifas.application.core.domain;

import java.io.InputStream;


public class File {

  private Long id;

  private Long raffleId;

  private String name;

  private InputStream inputStream;

  public File() {
  }

  public static File builder() {
    return new File();
  }

  public Long getId() {
    return id;
  }

  public File id(Long id) {
    this.id = id;
    return this;
  }

  public Long getRaffleId() {
    return raffleId;
  }

  public File raffleId(Long raffleId) {
    this.raffleId = raffleId;
    return this;
  }

  public String getName() {
    return name;
  }

  public File name(String name) {
    this.name = name;
    return this;
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public File inputStream(InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setRaffleId(Long raffleId) {
    this.raffleId = raffleId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }
}
