package com.freedom.search;

/**
 * @author freedom
 * @date 2020/10/10 21:24
 * @description 1、对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找，速度较快；
 *              2、关键字分布不均匀的情况下，该方法不一定比折半查找要好。
 */
public class InsertValueSearch {

    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[right - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        if (findVal > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
