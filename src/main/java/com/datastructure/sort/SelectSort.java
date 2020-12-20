package com.datastructure.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public void sort(int[] arr) {
        /**
         * 算法有个重要的思想，先简单，后复杂，然后综合起来。
         *
         * 假设对 50, 30, 10, 20 进行 从小到大 排序
         *
         * 找出这个数组中 最小 的一个数，然后与 第一个数 交换位置，
         * 再从剩下的数继续寻找 最小 的一个数，与剩下的数的 第一个数 交换位置
         *
         * 第 1 遍循环
         * 50, 30, 10, 20
         * 10, 30, 50, 20
         *
         * 可以看到最小的数 10 归位。
         *
         * 那么需要对剩下 3个 元素(30, 50, 20)做相同处理
         *
         * 第 2 遍循环
         * 10, 30, 50, 20
         * 10, 20, 50, 30
         *
         * 可以看到最小的数 20 归位。
         *
         * 那么需要对剩下 2个 元素(30, 50)做相同处理
         *
         * 第 3 遍循环
         * 10, 20, 50, 30
         * 10, 20, 30, 50 (当剩余 1个 元素时，说明排序结束。这里就是 50)
         *
         *
         * 那么数组长度是 n, 经过 n - 1 次的循环，得到结果。
         *
         */

        int length = arr.length;
        int num = length - 1;

        for (int i = 0; i < num; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            /**
             * 这里为什么 + 1？
             *
             * 先假设不 +1，那么 i = 0， j = i
             * 在下面的 if 语句里就相当于
             * arr[i] = arr[0]
             * arr[j] = arr[0]
             * 两个相同的数做比较，没有必要。
             */
            for (int j = i + 1; j < length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[minIndex];
                }
            }

            /**
             * 先假设 minIndex == i, 那就说明执行了上面的 for 循环，
             * 结果 minIndex 没有发生变化，那就说明本轮 for 循环结束不需要 交换。
             */
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
