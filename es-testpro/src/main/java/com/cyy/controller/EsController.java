package com.cyy.controller;

import com.cyy.config.ElasticsearchConfig;
import com.cyy.domain.Product;
import com.cyy.mapper.StudentMapper;
import lombok.extern.log4j.Log4j;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author:CYY
 * @create: 2023-05-23 15:06:33
 * @Description:
 */
@RestController
@RequestMapping("/es")
@Log4j
public class EsController {
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private StudentMapper studentMapper;

    @DeleteMapping("deleteIndex")
    public void deleteIndex() {
        boolean b = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除成功！");
    }

    @PostMapping("saveDoc")
    public void saveDoc() {
        Product product = new Product();
        product.setId(4L);
        product.setTitle("小米 8 手机");
        product.setCategory("手机");
        product.setPrice(7777777.0);
        product.setImages("http://www.atguigu/xm.jpg");
        studentMapper.save(product);
    }

    @GetMapping("byId")
    public void byId() {
        Iterable<Product> all = studentMapper.findAll();
        all.forEach(System.out::println);
        ;
    }

    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    @GetMapping("/termQuery")
    public void termQuery() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", " 小米");
        Iterable<Product> products = studentMapper.search(termQueryBuilder);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
