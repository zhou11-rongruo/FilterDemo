package com.example.filterdemo1.controller;

import com.example.filterdemo1.entity.BatchHandlerRequest;
import com.example.filterdemo1.entity.FeedBackData;
import com.example.filterdemo1.service.FeedBackService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author zhou11
 * @version 1.0.0
 * @description TODO
 * @date 2024/5/28
 */
@RestController()
@ResponseBody
public class BatchHandlerController {

    private static final ExecutorService pool = Executors.newFixedThreadPool(3);

    @Resource
    private FeedBackService feedBackService;

    @PostMapping("/handle")
    private Boolean handler(@RequestBody BatchHandlerRequest request){


        CompletableFuture<List<FeedBackData>> listCompletableFuture = CompletableFuture
                .supplyAsync(() -> feedBackService.query(), pool)
                .thenApplyAsync(res -> {
                    List<FeedBackData> collect = res.stream()
                            .peek(t -> t.setContent("1111111"))
                            .collect(Collectors.toList());
                    System.out.println("2222222");
                    return collect;
                }, pool);




        System.out.println("11111111");
        return true;
    }


    static class DataProcessor implements Runnable {
        private String data;

        DataProcessor(String data) {
            this.data = data;
        }

        public void run() {
            try {
                Thread.sleep(30000);
                System.out.println(data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 数据处理逻辑
        }
    }


    @GetMapping("/handleState")
    private String handleState(){

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) pool);
        StringBuilder sb = new StringBuilder();
        System.out.println();



        int queueSize = tpe.getQueue().size();
        sb.append("当前排队线程数：").append(queueSize).append("---");
        System.out.println("当前排队线程数："+ queueSize);

        int activeCount = tpe.getActiveCount();

        sb.append("当前活动线程数：").append(activeCount).append("---");
        System.out.println("当前活动线程数："+ activeCount);

        long completedTaskCount = tpe.getCompletedTaskCount();
        sb.append("执行完成线程数：").append(completedTaskCount).append("---");
        System.out.println("执行完成线程数："+ completedTaskCount);

        long taskCount = tpe.getTaskCount();
        sb.append("总线程数：").append(taskCount).append("---");
        System.out.println("总线程数："+ taskCount);
        return sb.toString();
    }

}
