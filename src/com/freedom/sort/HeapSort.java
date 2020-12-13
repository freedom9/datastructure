package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/11/4 21:45
 */
public class HeapSort {

    public static void heapSort(int arr[]) {
        int temp = 0;

        // arr.length / 2 - 1是是第一个非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            buildHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap(arr, 0, i);
        }
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示还有多少个元素继续调整
     */
    private static void buildHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶
        arr[i] = temp;
    }
}
