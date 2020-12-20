package com.datastructure.sort;


/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1, new int[arr.length]);
    }


    private void sort(int[] arr, int leftIndex, int rightIndex, int[] temp) {
        // 这里是 分
        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            sort(arr, leftIndex, midIndex, temp); // 分 左边 的数
            sort(arr, midIndex + 1, rightIndex, temp); // 分 右边 的数

            merge(arr, leftIndex, midIndex, rightIndex, temp);
        }
    }

    private void merge(int[] arr, int leftIndex, int midIndex, int rightIndex, int[] temp) {
        /**
         * 注意， left -> mid 是左边有序数列，
         * mid + 1 -> right 是右边有序数列
         *
         */
        int i = leftIndex;
        int j = midIndex + 1;
        int t = 0;


        /**
         * 1, i 与 j 相比，将 小的数 放入 temp
         */
        while (i <= midIndex && j <= rightIndex) {

            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        /**
         * 2, 做完上面的操作，检查 左右两边 是否还有剩余
         * 的数，把剩余的数 依次放入 temp。（注意，左右两边本身就是有序的，
         * 所以把剩余的数 依次 放入 temp 里没有问题。）
         */

        while (i <= midIndex) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= rightIndex) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        /**
         * 3, 将 temp 中有序的数，拷贝到 arr 中。
         */
        t = 0;
        int tempLeft = leftIndex;
        while (tempLeft <= rightIndex) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
