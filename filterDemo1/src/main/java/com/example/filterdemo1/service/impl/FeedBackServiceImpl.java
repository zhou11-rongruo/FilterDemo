package com.example.filterdemo1.service.impl;

import com.example.filterdemo1.entity.FeedBackData;
import com.example.filterdemo1.service.FeedBackService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou11
 * @version 1.0.0
 * @description TODO
 * @date 2024/5/29
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Override
    public List<FeedBackData> query() {

        try {
            Thread.sleep(10000);
            List<FeedBackData> feedBackDataList = new ArrayList<>();
            feedBackDataList.add(new FeedBackData("1", "张三", "张三的反馈"));
            feedBackDataList.add(new FeedBackData("2", "李四", "李四的反馈"));
            feedBackDataList.add(new FeedBackData("3", "王五", "王五的反馈"));
            feedBackDataList.add(new FeedBackData("4", "赵六", "赵六的反馈"));
            feedBackDataList.add(new FeedBackData("5", "田七", "田七的反馈"));
            feedBackDataList.add(new FeedBackData("6", "周八", "周八的反馈"));
            return feedBackDataList;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
