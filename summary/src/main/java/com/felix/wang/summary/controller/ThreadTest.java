package com.felix.wang.summary.controller;

import com.felix.wang.summary.domain.Data;
import com.felix.wang.summary.domain.DataRight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * @author: Felix-wang
 * @Date: 2020-08-18 15:15
 */
@RequestMapping("/test/v2/")
@RestController
public class ThreadTest {

    @GetMapping("wrong")
    public int wrong(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        Data.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().wrong());
        return Data.getCounter();

    }

    @GetMapping("right")
    public int right(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new DataRight().right());
        return DataRight.getCounter();

    }

}
