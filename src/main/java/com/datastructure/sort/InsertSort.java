package com.datastructure.sort;

/**
 * 插入排序
 */
public class InsertSort {
    public void sort(int[] arr) {
        /**
         * 基本思路：把 n个 待排序的元素看成一个 有序表 和 无序表，
         * 开始时，有序表只有 1个 元素，无序表有 n-1个 元素。排序
         * 过程中每次从 无序表 中取出 第1个 元素，将它插入到 有序表
         * 中合适的位置。
         *
         * 注意，总是从 当前元素（有序表第一个元素） 的 前一个元素（无序表的最后一个元素），
         * 倒序无序表去对比，找插入位置。 如此循环操作。
         *
         * 那么数组长度是 n, 经过 n - 1 次的循环，得到结果。
         *
         *
         * 假设对 50, 30, 10, 20 进行 从小到大 排序
         *
         * 50 是有序表；30, 10, 20 是无序表。 第 1 遍循环得到下面的结果
         * 30, 50 是有序表；10, 20 是无序表。 第 2 遍循环得到下面的结果
         * 10, 30, 50 是有序表；20 是无序表。 第 3 遍循环得到下面的结果 （注意这里就结束了）
         * 10, 20, 30, 50 是有序表；无序表无数据。
         *
         */

        int needInsertValue = 0; // 需要插入的值
        int insertIndex = 0; // 要插入的下标位置

        /**
         * i 从 1 开始，就代表 50 是有序表；30, 10, 20 是无序表。
         * 所以这里也不需要 length - 1, 因为已经从 1 下标开始，跳过了
         * 第 0 下标。
         */
        for (int i = 1; i < arr.length; i++) {
            needInsertValue = arr[i]; // 需要插入的值
            insertIndex = i - 1; // 要插入的下标位置

            /**
             * insertIndex >= 0, 为了避免下标越界。
             * 以及也是为什么在 while 循环后，需要 insertIndex + 1 来插入值
             * 例如 insertIndex = -1 时，说明 要插入的值 比 有序表 里的每一个
             * 数据都小，那么就插入到有序表的头，也就是第0个下标(insertIndex + 1)
             *
             * 如果 needInsertValue <= arr[insertIndex] = false，说明
             * 要插入的值 > insertIndex 所对应的值，那么就应该插入到 insertIndex
             * 的右边（也就是 indexInsert + 1 的位置。以及也是为什么在 while 循环后，需要 insertIndex + 1 来插入值）
             */
            while (insertIndex >= 0 && needInsertValue <= arr[insertIndex]) {
                /**
                 * 这里 要插入的值 <= insertIndex 所对应的值。
                 * 那 要插入的值，应该放在 insertIndex 这个位置。
                 * 而原本的 insertIndex 所对应的值，应该往右挪动一位，
                 * 也就是放在 insertIndex + 1 这个位置。
                 *
                 * 假如这样。
                 *   30, 50 是有序表；10, 20 是无序表。
                 *    0,   1,        2,  3
                 *
                 * needInsertValue = 10，
                 * insertIndex = 1
                 *
                 * 10 < 50, 将 insertIndex，往右挪动一位，这时的过程是这样的。
                 *
                 *   30, 50, 10, 20  注意 10 已经被赋值给 needInsertValue，被保存下来
                 *    0,  1,  2,  3  所以 50 往右挪动一位，没有问题，得到下面的结果
                 *
                 *   30, 50, 50, 20
                 *    0,  1,  2,  3
                 *
                 *    insertIndex =  insertIndex - 1 = 0
                 *
                 * 10 < 30, 将 insertIndex，往右挪动一位，这时的过程是这样的。
                 *
                 *   30, 50, 50, 20  注意 10 已经被赋值给 needInsertValue，被保存下来
                 *    0,  1,  2,  3  所以 30 往右挪动一位，没有问题，得到下面的结果
                 *
                 *   30, 30, 50, 20
                 *    0,  1,  2,  3
                 *
                 *    insertIndex = insertIndex - 1 = -1
                 *
                 *  insertIndex = -1， while 循环结束。
                 *  将 needInsertValue = 10，赋值给 insertIndex + 1 = 0，这个位置。
                 *
                 *   10, 30, 50, 20
                 *    0,  1,  2,  3
                 *
                 */
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex -= 1;
            }

            arr[insertIndex + 1] = needInsertValue;
        }


    }
}
