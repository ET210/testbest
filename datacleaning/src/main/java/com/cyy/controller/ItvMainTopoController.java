package com.cyy.controller;

import com.cyy.service.ItvMainTopoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:CYY
 * @create: 2023-05-17 16:08:00
 * @Description:
 */
@RestController
@RequestMapping("/query")
public class ItvMainTopoController {


    @Resource
    private ItvMainTopoService itvMainTopoService;

    @GetMapping("get")
    public void getDate() {
        long l = System.currentTimeMillis();
        itvMainTopoService.queryall();
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);

    }
}
