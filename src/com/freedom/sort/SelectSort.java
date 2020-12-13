package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/3 21:04
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        int minValue = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            minValue = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minIndex = j;
                    minValue = arr[minIndex];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
