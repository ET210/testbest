package com.cyy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Date;
import java.util.List;

/**
 * @author:CYY
 * @create: 2023-06-29 08:56:08
 * @Description:
 */
@Mapper
public interface  UserMapper02 {
    //单个属性
    //@Mapping(source = "pwd",target = "password")
    //多个属性


   /* private Integer id;
    private Integer number ;
    private String address;
    private Date birth;
    private Boolean isDisable;*/
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "number", target = "number"),
            @Mapping(source = "address", target = "address"),
            @Mapping(target = "birth", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "isDisable", target = "isDisable")
    })
    List<UserDto> userToUserDto(List<User> user);
}
