package com.cyy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
        Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getId() + "正在执行任务");
            }
            return null;
        }, executorService);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getId() + "正在执行任务000000");
            return null;
        }, executorService);

    }

    public static void index() {
        System.out.println("hhaaha");
    }


    public static void hello() {
        System.out.println("hello");
    }
}


