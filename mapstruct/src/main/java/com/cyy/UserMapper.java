package com.cyy;

import org.mapstruct.Mapper;

@Mapper(uses = {BooleanStrFormat.class})
public interface UserMapper {
    UserDto userToNewUserDto(User user);
}