package com.cyy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.domain.ItvMainTopo;
import com.cyy.service.ItvMainTopoService;
import com.cyy.mapper.ItvMainTopoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author HUAWEI
 * @description 针对表【itv_main_topo】的数据库操作Service实现
 * @createDate 2023-05-17 16:05:04
 */
@Service
public class ItvMainTopoServiceImpl extends ServiceImpl<ItvMainTopoMapper, ItvMainTopo>
        implements ItvMainTopoService {

    @Resource
    private ItvMainTopoMapper itvMainTopoMapper;

    @Override
    public void queryall() {
        Integer count = baseMapper.getCount();
        int totalRecords = count; // 总记录数
        int batchSize = 30000; // 每批处理的记录数
        int threads = 8; // 线程数
        int totalPages = (int) Math.ceil((double) totalRecords / batchSize);
       // CompletableFuture.supplyAsync()
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int page = 0; page < totalPages; page++) {
            int lastId = page * batchSize;
            int bachsize1 = lastId + batchSize;
            executor.execute(() -> {
                List<ItvMainTopo> dataBatch = itvMainTopoMapper.fetchData(lastId, bachsize1);
                // processBatch(dataBatch);
            });

        }
        executor.shutdown();
    }
}




