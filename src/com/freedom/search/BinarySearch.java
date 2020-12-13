package com.freedom.search;

/**
 * @author freedom
 * @date 2020/10/10 20:44
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        // 有溢出
//        int mid = (left + right) / 2;
        // 无溢出
        int mid = (left & right) + ((left ^ right) >> 1);

        if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
