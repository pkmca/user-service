package com.example.userservice.model;

import com.example.userservice.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "'User'")
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
  private Role role;
}