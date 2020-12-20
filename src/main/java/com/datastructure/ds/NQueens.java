package com.datastructure.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后
 */
public class NQueens {
    private List<List<List<Integer>>> res = new ArrayList<>();

    public List<List<List<Integer>>> solveNQueens(int n) {
        List<List<Integer>> board = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> objects = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                objects.add(0);
            }
            board.add(objects);
        }

        backtrack(board, 0, n);

        return res;
    }

    private void backtrack(List<List<Integer>> board, int row, int n) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isInvalid(board, row, column, n)) {
                continue;
            }
            board.get(row).set(column, 1);
            backtrack(board, row + 1, n);
            board.get(row).set(column, 0);
        }
    }

    private boolean isInvalid(List<List<Integer>> board, int row, int col, int n) {
        // 检查列
        for (int i = 0; i < row; i++) {
            Integer integer = board.get(i).get(col);
            if (integer == 1) {
                return true;
            }
        }

        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            Integer integer = board.get(i).get(j);
            if (integer == 1) {
                return true;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            Integer integer = board.get(i).get(j);
            if (integer == 1) {
                return true;
            }
        }
        return false;
    }
}
