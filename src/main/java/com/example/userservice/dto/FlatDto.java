package com.example.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatDto {

    private Integer id;

    private Integer ownerId;

    private Integer tenantId;

    private String flatNumber;

    private String type;

    private String floor;

    private String block;
}
