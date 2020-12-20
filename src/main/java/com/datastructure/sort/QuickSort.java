package com.datastructure.sort;

/**
 * 快速排序
 */
public class QuickSort {


    public void sort(int[] arr) {

        sort(arr, 0, arr.length - 1);

    }

    private void sort(int[] arr, int leftIndex, int rightIndex) {
        /**
         * 定一个基数，将小于基数的值，放在基数左边，
         * 大于基数的值，放在基数右边。然后，左右两边
         * 的数，重复此操作。
         *
         * 如何 将小于基数的值，放在基数左边。大于基数的值，放在基数右边？
         *
         * 从左边开始找 大于基数的值，找到停下。然后从右边开始找 小于基数的值，
         * 找到停下。然后交换。再继续重复此操作。
         *
         */

        int middleValue = arr[(leftIndex + rightIndex) / 2];
        int l = leftIndex;
        int r = rightIndex;

        int temp = 0;

        while (l < r) {

            // 找到 大于 中间值 的数
            while (arr[l] < middleValue) {
                l += 1;
            }

            // 找到 小于 中间值 的数
            while (arr[r] > middleValue) {
                r -= 1;
            }

            // 这里说明，数据原本左边的数，就是小于基数的，
            // 右边的数，就是大于基数的。
            // 那么不需要有交换的操作。
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            /**
             * 为什么需要下面的代码。
             *
             * 假设遇到这样的数据
             *
             *   50, 10, 10, 20, 6
             *    0, 1,  2,  3, 4
             *
             * l = 0; // left index
             * r = 4; // right index
             * m = 2; // middle index
             * mValue = 10; // middle value
             *
             *
             * arr[l=0]=50 > arr[m=2]=10, arr[r=4]=6 < arr[m=2]=10 所以会交换，变成下面这样
             *
             *   6, 10, 10, 20, 50
             *    0, 1,  2,  3, 4
             *
             *
             * l = 1; // left index
             * r = 2; // right index 这里为什么是 2，因为上面的 while 循环（arr[r] > mValue）就一直 -1
             * m = 2; // middle index
             * mValue = 10; // middle value
             *
             * arr[l=1]=10 > arr[m=2]=10 == false,
             * arr[r=2]=10 < arr[m=2]=10 == false,
             *
             * 满足不了交换条件，同时，（l=1,r=2,都是10） 仅凭上面的代码，
             * l 与 r 永远相遇相遇不了，是一个死循环。
             *
             *
             */
            if (arr[l] == middleValue) {
                r -= 1;
            }

            if (arr[r] == middleValue) {
                l += 1;
            }
        }

        // 说明 下标都在 middleIndex 上
        // 在处理左右两边的数时，应该不包含 middleIndex 本身。
        if (l == r) {
            r -= 1;
            l += 1;
        }

        if (leftIndex < r) { // 处理左边 小于 middleIndex 的数
            sort(arr, leftIndex, r);
        }

        if (l < rightIndex) { // 处理右边 大于middleIndex 的数
            sort(arr, l, rightIndex);
        }
    }


}
