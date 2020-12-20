package com.datastructure.recursive;

/**
 * 迷宫 找路径
 */
public class Maze {
    public static void main(String[] args) {
        int row = 8;
        int column = 7;
        int[][] map = new int[row][column];

        // 将 第一行 和 最后一行 置为 1
        for (int i = 0; i < column; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        // 将 第一列 和 最后一列 置为 1
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][column - 1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
//        map[2][2] = 1;
//        map[1][2] = 1;

        System.out.println("迷宫---------");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("迷宫---------找到的结果");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j) {
        /**
         * 0 未走过的路；
         * 1 墙；
         * 2 路已走过，是通的；
         * 3 路已走过，不通。
         *
         * 从 (1, 1) 的位置开始找路，到 (6,5) 为找到。
         *
         * 定义一个策略，下 -> 右 -> 上 -> 左 这样找。
         * 这个策略是可以变的，不同的策略找到的路线不同。
         * 如果要找到 最短路线 的那个策略，笨一点的方法是，
         * 每个策略都走一边，把结果保存下来，对比哪个结果
         * 的路线（长度）最短。
         */

        if (map[6][5] == 2) { // 说明出口找到，整个路径搜索结束
            return true;
        } else {
            if (map[i][j] == 0) { // 未走过的路，可以探索
                map[i][j] = 2; // 先假设路是通的。

                if (setWay(map, i + 1, j)) { // 下
                    return true;
                } else if (setWay(map, i, j + 1)) { // 右
                    return true;
                } else if (setWay(map, i - 1, j)) { // 上
                    return true;
                } else if (setWay(map, i, j - 1)) { // 左
                    return true;
                } else { // 路不通
                    // 前面假设过路是通的，也就是 2
                    // 下 -> 右 -> 上 -> 左 找了一圈，不通，置为 3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // map[i][j] == 1 墙；
                // map[i][j] == 2 路已走过，是通的；
                // map[i][j] == 3 路已走过，不通。
                // 要不是墙，要不路已走过，返回 false
                return false;
            }
        }
    }
}
