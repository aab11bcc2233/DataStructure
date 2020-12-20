package com.datastructure.ds;

import com.datastructure.ds.Fib;
import org.junit.jupiter.api.Test;

class FibTest {

    @Test
    void fib() {
        long num = new Fib().fib(50);
        System.out.println(num);
    }

    @Test
    void fib2() {
        long num = new Fib().fib2(50);
        System.out.println(num);
    }
}