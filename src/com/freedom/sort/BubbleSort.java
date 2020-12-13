package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/2 20:24
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        int temp = 0;
        // 标记是否进行过交换，用来优化排序
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                // 排序时，一次都没交换，代表已经排好序了
                break;
            }
        }
    }
}
