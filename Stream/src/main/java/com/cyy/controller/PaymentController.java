package com.cyy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author:CYY
 * @create: 2023-06-08 09:37:35
 * @Description:
 */
@RestController
@RequestMapping("/a")
@RequiredArgsConstructor
public class PaymentController {
    @GetMapping("/test")
    public void get() {
        index();
        System.out.println("=============");
        hello();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"hsdfs");
        }
    }

    public static void index() {
        System.out.println("hhaaha");
    }


    public static void hello() {
        System.out.println("hello");
    }
}


