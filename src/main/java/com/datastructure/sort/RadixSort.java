package com.datastructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public void sort(int[] arr) {

        /**
         * 注意，有负数时，不要使用 基数排序，或者，对其改造，让
         * 其支持负数。
         *
         * 假设排序这组数据
         *   53, 3, 542, 748, 14, 214
         *
         * 最大的数是 3位数，依次按照 个、十、百，这个顺序，
         *
         * 比如先是 个位，个位 是3， 就把 53，放入下标是
         * 3 这个桶里，将这组数据遍历结束。
         *
         * 然后 将桶里 的数据，拷贝到 原始数组中。
         *
         * 再十位，进行相同操作。
         * 再百位，进行相同操作。
         */

        // 找到最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 最大的数的位数
        int maxLength = String.valueOf(max).length();

        // 代表 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 这十个数
        int bucketSize = 10;
        /**
         * 初始化 位数 的桶。
         * 为什么每个桶的长度是 arr.length?
         *
         * 假设排序这样一组数据。
         *   51, 1, 541, 741, 11, 211
         * 可以看到 个位，都是一样的，需要放进同一个桶里。
         *
         * 但是也可以看到，等 arr.length 非常大时，占用的
         * 内存空间也很大。
         *
         * 测试 800w 个数据时，还好。
         * 当测试 8000w 个数据是，出现如下错误。
         *    java.lang.OutOfMemoryError: Java heap space
         *
         * 来算一下所占用的空间：
         *   10 * 80000000 * 4 = 3200000000 byte
         *   3200000000 / 1024 / 1024 / 1024 = 2.98G
         */
        int[][] bucket = new int[bucketSize][arr.length];
        // 记录 bucket 的每一个桶中有效数据的个数。
        int[] bucketElementCount = new int[bucketSize];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                /**
                 * 假设从这组数据中
                 *   53, 3, 542, 748, 14, 214
                 * 挑出 748 来得到它的 每一位 的数。
                 *
                 *   个位数 = 748 / 1 % 10 = 8
                 *   十位数 = 748 / 10 % 10 = 74 % 10 = 4
                 *   百位数 = 748 / 100 % 10 = 7 % 10 = 7
                 */
                int unitNum = arr[j] / n % 10;
                /**
                 * 假设当前是 748 的个位数
                 *   个位数 = 748 / 1 % 10 = 8
                 *
                 * bucket[unitNum] = bucket[8]    8 所在的桶
                 * bucketElementCount[unitNum]  = bucketElementCount[8] 8 所在的桶的有效数据的个数（下标）
                 */
                bucket[unitNum][bucketElementCount[unitNum]] = arr[j];
                bucketElementCount[unitNum] += 1;
            }

            // 将桶里的数据，拷贝到原始数组
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementCount[k] != 0) { // 桶里有数据时才会拷贝
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index += 1;
                    }

                    // 结束后将桶里的有效数据的个数 清0
                    bucketElementCount[k] = 0;
                }
            }
        }

    }
}
