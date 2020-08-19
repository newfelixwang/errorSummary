package com.felix.wang.summary.Test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Felix-wang
 * @Date: 2020-08-18 15:00
 */
@Slf4j
public class Interesting {
    volatile int a = 1;
    volatile int b = 1;

    //增加synchronized 是针对这个方法的
    public synchronized void add() {
        log.info("add start");
        for (int i = 0; i < 100000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public synchronized void compare() {
        log.info("compare start");
        for (int i = 0; i < 100000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }
}


