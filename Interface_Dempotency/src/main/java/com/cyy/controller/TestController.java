package com.cyy.controller;

import com.cyy.annotation.Idempotent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:CYY
 * @create: 2023-05-30 21:00:50
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/demo")
    @Idempotent(expire = 60)
    public String demo(Integer id) {
        //处理请求
        return "成功！";
    }

}
