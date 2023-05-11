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

     @OneToOne(cascade = CascadeType.ALL)
     private User user;

    @JsonProperty
    @Column(name = "flatNumber", nullable = false)
    private String flatNumber;

    @JsonProperty
    @Column(name = "type")
    private String type;

    @JsonProperty
    @Column(name = "floor")
    private String floor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @JsonProperty
    @Column(name = "block")
    private String block;
}
