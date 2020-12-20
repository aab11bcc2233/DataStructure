package com.datastructure.ds;

import com.datastructure.ds.Arrangement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ArrangementTest {

    @Test
    void permute() {
        List<List<Integer>> permute = new Arrangement().permute(new int[]{1, 2, 3});

        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }
}