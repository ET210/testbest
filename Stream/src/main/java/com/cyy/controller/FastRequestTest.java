package com.cyy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求快速测试
 *
 * @author CYY
 * @date 2023/07/26
 */
@RestController
@RequestMapping("/a")
public class FastRequestTest {
    @GetMapping("/b")
    public String test(String request) {
        return "hello world" + request;
    }
}
