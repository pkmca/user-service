package com.example.userservice.model;

import com.example.userservice.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "Person")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @JsonProperty
  @Column(name = "email", nullable = false)
  private String email;

  @JsonProperty
  @Column(name = "firstName", nullable = false)
  private String firstName;

  @JsonProperty
  @Column(name = "middleName")
  private String middleName;

  @JsonProperty
  @Column(name = "lastName")
  private String lastName;

  @JsonProperty
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  @JsonProperty
  @Column(name = "contactNumber", nullable = false)
  private String contactNumber;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
}
