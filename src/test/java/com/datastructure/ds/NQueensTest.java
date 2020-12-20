package com.datastructure.ds;

import com.datastructure.ds.NQueens;
import org.junit.jupiter.api.Test;

import java.util.List;

class NQueensTest {

    @Test
    void solveNQueens() {
        List<List<List<Integer>>> lists = new NQueens().solveNQueens(4);
        System.out.println(lists.size());
    }
}