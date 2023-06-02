package com.cyy.controller;
import com.cyy.domain.User;
import com.cyy.esconfig.EsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.*;
import org.elasticsearch.client.indices.GetIndexRequest;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * @author:CYY
 * @create: 2023-05-23 10:33:03
 * @Description:
 */
@RestController
@RequestMapping("/es")
public class EsController {
    @Resource
    private EsConfig esConfig;

    @PutMapping("/createIndex")
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("information");
        CreateIndexResponse createIndexResponse = esConfig
                .restHighLevelClient()
                .indices()
                .create(request, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作 ：" + acknowledged);
        esConfig.restHighLevelClient().close();
    }

    @GetMapping("getIndex")
    public void getIndex() throws IOException {
        // 查询索引
        GetIndexRequest request = new GetIndexRequest("information");
        GetIndexResponse getIndexResponse = esConfig.restHighLevelClient().indices().get(request, RequestOptions.DEFAULT);
        // 响应状态
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());

        esConfig.restHighLevelClient().close();

    }

    @PostMapping("/docInsert")
    public void insertDocument() throws IOException {
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("information").id("004");
        User user = new User();
        user.setName("王五");
        user.setAge(99);
        user.setAddress("浙江省杭州市");
        user.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);
        esConfig.restHighLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        esConfig.restHighLevelClient().close();

    }

    @GetMapping("/matchAll")
    public void matchAll() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("information");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        SearchResponse response = esConfig.restHighLevelClient().search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

    }

    @GetMapping("/match")
    public void matchQuery() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("information");
        // Create a query that matches all documents
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "四明");
        request.source(new SearchSourceBuilder().query(matchQueryBuilder));
        SearchResponse response = esConfig.restHighLevelClient().search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            System.out.println(hit.getExplanation());
            System.out.println(hit);
            System.out.println(hit.getIndex());
            System.out.println(hit.getSourceAsMap());
            hit.getSourceAsMap().forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
            System.out.println("==========================");
            String address = (String) hit.getSourceAsMap().get("address");
            System.out.println("address = " + address);
        }
    }

    @GetMapping("/termQuery")
    public void termQuery() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("information");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "三")));
        SearchResponse response = esConfig.restHighLevelClient().search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            hit.getFields().forEach((key, value) -> System.out.println("Field: " + key + ", Value: " + value.getValue()));
        }
    }

    @GetMapping("/rangeQuery")
    public void rangeQuery() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("information");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        rangeQuery.gte(1);
        rangeQuery.lt(100);

        builder.query(rangeQuery);
        request.source(builder);
        SearchResponse response = esConfig.restHighLevelClient().search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
