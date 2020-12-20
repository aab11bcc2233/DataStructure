package com.datastructure.ds;

public class Coin {

//    public int coinChange(List<Integer> coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//
//        if (amount < 0) {
//            return -1;
//        }
//
//        int res = 0;
//
//        for (Integer coin : coins) {
//            int subProblem = coinChange(coins, amount - coin);
//            if (subProblem == -1) {
//                continue;
//            }
//
//            res = Math.min(res, 1 + subProblem);
//        }
//
//        if (res > 0) {
//            return res;
//        } else {
//            return -1;
//        }
//    }

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int coin : coins) {
            int num = amount - coin;
            findWay(coins, num, count + 1);
        }
    }

}
