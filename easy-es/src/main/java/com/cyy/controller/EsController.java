package com.cyy.controller;

import com.cyy.mapper.EsMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:CYY
 * @create: 2023-05-27 12:27:07
 * @Description:
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Resource
    private EsMapper esMapper;

    @RequestMapping("/testCreateIndexByEntity")
    public void testCreateIndexByEntity() {
        // 绝大多数场景推荐使用 简单至上
        esMapper.createIndex();
    }
}
