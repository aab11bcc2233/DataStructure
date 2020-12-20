package com.datastructure.recursive;

public class Queen8 {

    private int max = 8;
    private int[] arr = new int[max];
    private int resultCount = 0;

    public static void main(String[] args) {
        Queen8 queen = new Queen8();
        queen.check(0);
        System.out.printf("有%d种摆放方式", queen.resultCount);
    }

    /**
     *
     * @param n 第几个皇后，也就是第几行
     */
    public void check(int n) {
        if (n == max) { // 说明 8个皇后 已经摆放结束。 0-7 是8个数；8是第9个数。
            print();
            resultCount += 1;
            return;
        }

        /**
         * 这里用一维数组，代表了二维数组。
         * 一维数组的下标代表 行；
         * 一维数组的下标对应的值，代表列。
         */
        for (int i = 0; i < max; i++) {
            arr[n] = i;

            // 不在 同一行、同一列、对角线 上
            // 说明这个点的摆放位置没有问题
            if (isNotConflict(n)) {
                check(n + 1);
            }

            // 假设有冲突，那就会走 for 循环的 i++ 去判断下一列
        }
    }

    /**
     * 判断第n个皇后，是否与前面已经存在的皇后 不冲突
     * （也就是 不在 同一行、同一列、对角线 上）
     * @param n 第几个皇后，也就是第几行
     */
    public boolean isNotConflict(int n) {
        for (int i = 0; i < n; i++) {
            // 说明在同一列
            if (arr[i] == arr[n]) {
                return false;
            }

            // 说明在对角线上
            // 假设有两个点 (1, 2) 和 (2, 1)，当
            // 行 减去 行，也就是 2 - 1 = 1
            // 列 减去 列，也就是 1 - 2 = -1
            // 绝对值相等，说明在对角线上
            if (Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }

            // 注意没有 相同行 的判断，因为 n 代表行，而且 n 每次是 +1 的。
        }

        return true;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
