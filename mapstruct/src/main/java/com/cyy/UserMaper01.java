package com.cyy;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author:CYY
 * @create: 2023-06-29 08:41:04
 * @Description:
 */
@Mapper
public abstract class UserMaper01 {
    /**
     * 更新， 注意注解 @MappingTarget
     * 注解 @MappingTarget后面跟的对象会被更新。
     */
    abstract void updateDeliveryAddressFromAddress(User user, @MappingTarget UserDto userDto);
}
