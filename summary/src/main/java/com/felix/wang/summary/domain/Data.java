package com.felix.wang.summary.domain;

import lombok.Getter;

/**
 * @author: Felix-wang
 * @Date: 2020-08-18 15:14
 */
public class Data {

        //静态变量再多个实例中是共存，多线程必然出现线程安全问题
        @Getter
        private static int counter = 0;

        public static int reset() {
            counter = 0;
            return counter;
        }

        //非静态变量上加锁，只能保证多个线程同时执行一个实例，不能保证不同实例同时执行这个线程
        public synchronized void wrong() {
            counter++;
        }

}
