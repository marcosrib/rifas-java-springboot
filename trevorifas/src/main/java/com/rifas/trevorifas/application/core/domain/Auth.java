package com.rifas.trevorifas.application.core.domain;

import java.util.Set;

public class Auth {

  private String email;

  private String password;

  private Set<String> roles;
  private Boolean isAuth;


  public Auth(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Auth(String email, Set<String> roles) {
    this.email = email;
    this.roles = roles;
  }

  public Boolean getAuth() {
    return isAuth;
  }

  public void setAuth(Boolean auth) {
    isAuth = auth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRoles() {
    return roles;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }
}
