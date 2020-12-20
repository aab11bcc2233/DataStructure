package com.datastructure.sort;

import com.datastructure.sort.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class BubbleSortTest {

    @Test
    void sort() {
        int[] arr = {50, 30, 10, 20, 6};
        int[] result = {6, 10, 20, 30, 50};

        System.out.println("排序前：" + Arrays.toString(arr));

        new BubbleSort().sort(arr);

        System.out.println("排序后：" + Arrays.toString(arr));

        Assertions.assertArrayEquals(result, arr);
    }

    @Test
    void sortTime() {

        Date beforeDate = new Date();
        String beforeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeDate);
        System.out.println("排序开始时间：" + beforeTime);

        int length = 80000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }

        new BubbleSort().sort(arr);

        Date afterDate = new Date();
        String afterTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(afterDate);
        System.out.println("排序结束时间：" + afterTime);


        long l = afterDate.getTime() - beforeDate.getTime();
//        String time = new CountDownCalc().calc(l).toFormat("d", "H", "m", "s", false);

//        System.out.println("花费时间：" + time);
    }
}