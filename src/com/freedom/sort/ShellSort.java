package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/9 21:05
 */
public class ShellSort {

    /**
     * 希尔排序（交换法）变种的冒泡排序，速度慢
     * @param arr
     */
    public static void swapShellSort(int[] arr) {
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >=0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序（移位法）变种的插入排序，速度快
     * @param arr
     */
    public static void shiftShellSort(int[] arr) {
        int index = 0;
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                index = i;
                temp = arr[i];

                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && temp < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                     }
                    arr[index] = temp;
                }
            }
        }
    }
}
