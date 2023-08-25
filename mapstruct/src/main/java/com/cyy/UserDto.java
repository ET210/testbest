package com.cyy;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private Integer number ;
    private String address;
    private Boolean isDisable;
}