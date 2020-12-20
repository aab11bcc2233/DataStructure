package com.datastructure.ds;

import com.datastructure.ds.Coin;
import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    void coinChange() {
        int i = new Coin().coinChange(new int[]{1, 2, 5}, 3);
        System.out.println(i);
    }
}