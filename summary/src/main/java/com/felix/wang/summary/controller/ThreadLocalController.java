package com.felix.wang.summary.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Felix-wang
 * @Date: 2020/7/6 14:27 下午
 */
@RequestMapping("/test/v1/")
@RestController
public class ThreadLocalController {


    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    @GetMapping("wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before  = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after  = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        Map result = new HashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }

    @GetMapping("right")
    public Map right(@RequestParam("userId") Integer userId) {

        try {
            //设置用户信息之前先查询一次ThreadLocal中的用户信息
            String before  = Thread.currentThread().getName() + ":" + currentUser.get();
            //设置用户信息到ThreadLocal
            currentUser.set(userId);
            //设置用户信息之后再查询一次ThreadLocal中的用户信息
            String after  = Thread.currentThread().getName() + ":" + currentUser.get();
            //汇总输出两次查询结果
            Map result = new HashMap();
            result.put("before", before);
            result.put("after", after);
            return result;
        }finally {
            //web服务器往往采用线程池的方式来创建线程，在处理多个线程的时候会涉及线程
            // 重用的问题，在使用万threadLocal处理时需要及时清空数据
            currentUser.remove();
        }

    }

}
