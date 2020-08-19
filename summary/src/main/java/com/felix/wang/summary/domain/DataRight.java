package com.felix.wang.summary.domain;

import lombok.Getter;

/**
 * @author: Felix-wang
 * @Date: 2020-08-18 15:26
 */
public class DataRight {


        @Getter
        private static int counter = 0;
        private static Object locker = new Object();

        public void right() {
            synchronized (locker) {
                counter++;
            }
        }

}
