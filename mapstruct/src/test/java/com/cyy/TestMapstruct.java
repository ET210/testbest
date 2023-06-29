package com.cyy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:CYY
 * @create: 2023-06-28 16:42:35
 * @Description:
 */
@SpringBootApplication
@RunWith(SpringRunner.class)
public class TestMapstruct {

    @Test
    public void testMapstruct() {
 /*       User user = new User();
        user.setId("1");
        user.setNumber("1");
        user.setAddress("安徽");
        user.setBirth("2000-01-01");
        user.setIsDisable("true");
        // UserMapper mapper = Mappers.getMapper(UserMapper.class);
        //UserDto userDto = mapper.userToNewUserDto(user);
        //System.out.println(userDto.getIsDisable().getClass());
        UserMaper01 mapper = Mappers.getMapper(UserMaper01.class);
        UserDto userDto = new UserDto();
        System.out.println(userDto);
        mapper.updateDeliveryAddressFromAddress(user, userDto);
        System.out.println("=========================");
        System.out.println(userDto);
        System.out.println("================================");*/


    }

    @Test
    public void testMapstruct2() {
   /*     User user = new User();
        user.setId("1");
        user.setNumber("1");
        user.setAddress("安徽");
        user.setBirth("202001011500");
        user.setIsDisable("true");
        User user1 = new User();
        user1.setId("1");
        user1.setNumber("1");
        user1.setAddress("安徽");
        user1.setBirth("202001011500");
        user1.setIsDisable("true");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        UserMapper02 mapper = Mappers.getMapper(UserMapper02.class);
        List<UserDto> userDtos = mapper.userToUserDto(users);
        System.out.println("===================");
        for (int i = 0; i < userDtos.size(); i++) {
            System.out.println(userDtos.get(i));
        }*/
        System.out.println("===================");
        String s="202001011500";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }

}
