package com.felix.wang.summary.Test;

import com.felix.wang.summary.Test.thread.Interesting;

/**
 * @author: Felix-wang
 * @Date: 2020-08-18 15:00
 */
public class Test {

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(()->interesting.add()).start();
        new Thread(()->interesting.compare()).start();
    }


}
