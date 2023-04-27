package com.example.userservice.model;

import com.example.userservice.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonProperty
    @Column(name = "ownerId", nullable = false)
    private Integer ownerId;

    @JsonProperty
    @Column(name = "tenantId")
    private Integer tenantId;

    @JsonProperty
    @Column(name = "flatNumber", nullable = false)
    private String flatNumber;

    @JsonProperty
    @Column(name = "type")
    private String type;

    @JsonProperty
    @Column(name = "floor")
    private String floor;

    @JsonProperty
    @Column(name = "block")
    private String block;
}
