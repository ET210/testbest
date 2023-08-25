package com.cyy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cyy01.AreaDataVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        User user = new User();
        user.setId("1");
        user.setNumber("1");
        user.setAddress("安徽");
        user.setIsDisable("true");
        UserMapper02 mapper = Mappers.getMapper(UserMapper02.class);
        System.out.println("===================");
        UserDto userDto = mapper.userToUserDto(user);
        System.out.println(userDto);
        System.out.println("===================");

    }

    @Test
    public void testMapstruct3() throws JsonProcessingException {
        String json = "{\n" +
                "\t\"id\": 123,\n" +
                "\t\"name\": \"John\",\n" +
                "\t\"number\": \"19.87\"\n" +
                "}";
        String json01 = "{\n" +
                "\t\"AREANAME\": \"\",\n" +
                "\t\"AREACODE\": \"320000\",\n" +
                "\t\"RECORDDATE\": \"202001011500\",\n" +
                "\t\"GOOD_PLAY_RATE\": \"98.67\",\n" +
                "\t\"GOOD_LIVE_RATE\": \"98.78\",\n" +
                "\t\"GOOD_SWTIME_RATE\": \"99.87\",\n" +
                "\t\"LIVE_RATE\": \"98.45\",\n" +
                "\t\"RE_RATE\": \"96.34\"\n" +
                "},{\\n\" +\n" +
                "                \"\\t\\\"AREANAME\\\": \\\"\\\",\\n\" +\n" +
                "                \"\\t\\\"AREACODE\\\": \\\"320000\\\",\\n\" +\n" +
                "                \"\\t\\\"RECORDDATE\\\": \\\"202001011500\\\",\\n\" +\n" +
                "                \"\\t\\\"GOOD_PLAY_RATE\\\": \\\"98.67\\\",\\n\" +\n" +
                "                \"\\t\\\"GOOD_LIVE_RATE\\\": \\\"98.78\\\",\\n\" +\n" +
                "                \"\\t\\\"GOOD_SWTIME_RATE\\\": \\\"99.87\\\",\\n\" +\n" +
                "                \"\\t\\\"LIVE_RATE\\\": \\\"98.45\\\",\\n\" +\n" +
                "                \"\\t\\\"RE_RATE\\\": \\\"96.34\\\"\\n\" +\n" +
                "                \"}";
        ObjectMapper objectMapper = new ObjectMapper();

        AreaDataVo user = JSON.parseObject(json01, AreaDataVo.class);
        System.out.println(user);
        List<AreaDataVo> areaDataVos = JSONArray.parseArray(json01, AreaDataVo.class);
        System.out.println(areaDataVos);

        /*   System.out.println(areaDataVo.getRECORDDATE());*/

        System.out.println(); // Output: 123
//        System.out.println(user.getName()); // Output: John
//        System.out.println(user.getNumber());
    }

    @Test
    public void test02() throws Exception {
                // 获取当前时间
                LocalDateTime currentTime = LocalDateTime.now();
                // 获取前一小时的时间
                LocalDateTime previousHour = currentTime.minusHours(1);
                // 定义日期时间格式
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
                // 格式化前一小时的时间
                String formattedTime = previousHour.format(formatter);
                // 输出结果
                System.out.println("前一小时的时间：" + formattedTime);
    }

    @Test
    public void test03() throws Exception {
    }

}
