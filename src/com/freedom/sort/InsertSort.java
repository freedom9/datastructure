package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/3 21:37
 */
public class InsertSort {

    public static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            // insertVal < arr[t] 待插入的数还未找到插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;
        }
    }
}
