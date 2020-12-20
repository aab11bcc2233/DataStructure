package com.datastructure.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    /**
     * 用的 交换法，比较慢
     *
     * @param arr
     */
    public void sort(int[] arr) {

        int temp = 0;

        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) { // 这里用的交换法
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }

    /**
     * 用的 移位法，比上面的快
     *
     * @param arr
     */
    public void sort2(int[] arr) {

        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 这里参考下 InsertSort
                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }

            }
        }

    }
}
