package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/28 20:42
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // pivot就是基准数,这里就是每个数组的第一个
        int pivot = arr[left];
        int l = left;
        int r = right;
        int temp = 0;
        while (l < r) {
            // 从右边先开始的前提是我们选择序列中最左边的元素最为基准值。
            // 先从右边开始可以保证i,j相等的时候，arr[i] = arr[j] 小于基准值p。这样交换之后才能保证基准值
            // 所以先右再左上下这两个循环不能调换

            // 右边当发现小于p的值时停止循环
            while (arr[r] >= pivot && l < r) {
                r--;
            }
            // 左边当发现大于p的值时停止循环
            while (arr[l] <= pivot && l < r) {
                l++;
            }

            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }

        // 这里的arr[l]一定是小于pivot的，经过l、r交换后l处的值一定是小于pivot的(r先走)
        arr[left] = arr[l];
        arr[l] = pivot;

        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);
    }

    public static void quickSort1(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort1(arr, left, partition - 1);
            quickSort1(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 设置基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
