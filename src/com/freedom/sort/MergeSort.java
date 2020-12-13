package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/13 20:47
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param arr 原始数组
     * @param left
     * @param mid
     * @param right
     * @param temp 做中转的数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;

        // 1、先把左右两边的数据按照规则填充到temp数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        // 2、把剩余数据的一边依次全部填充到temp
        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= right) {
            temp[index++] = arr[j++];
        }

        // 3、将temp数组的元素拷贝到arr
        index = 0;
        while (left <= right) {
            arr[left++] = temp[index++];
        }

    }
}
