package com.freedom.search;

/**
 * @author freedom
 * @date 2020/10/10 21:03
 */
public class SearchTest {

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 22, 56, 67, 83, 199, 234, 562};
        System.out.println(BinarySearch.binarySearch(arr, 0, arr.length - 1, 8));

        System.out.println(InsertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 8));

        System.out.println(FibonacciSearch.fibonacciSearch(arr, 8));
    }
}
