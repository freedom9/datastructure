package com.freedom.search;

import java.util.Arrays;

/**
 * @author freedom
 * @date 2020/10/11 20:32
 * @description 对mid = low + F(k - 1) - 1的理解
 *  1、由斐波那契数列F(k) = F(k - 1) + F(k - 2)的性质，可以得到（F(k) - 1） = (F(k-1) - 1) + (F(k - 2) - 1) + 1。
 *     该式说明，只要顺序表得长度为F(k) - 1，则可以将该表分成长度为F(k - 1) - 1和F(k - 2) - 1得两段，从而中间位置
 *     为mid = low + f(k - 1) - 1。
 *  2、类似的。每一子段也可以用相同的方式分割，但顺序表长度n不一定刚好等于F(k - 1), 所以需要将原来的顺序表长度n
 *     增加至F(k - 1),这里的K值只要能使得F(k - 1)恰好大于或等于n即可。由以下代码得到顺序表长度增加后。新增的位置
 *     从n + 1到F(k - 1)位置，都赋为n位置的值即可。
 *     while (n > f[k] - 1) {
 *         k++;
 *      }
 */
public class FibonacciSearch {

    public static int fibonacciSearch(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        // 表示斐波那契分割数值的下标
        int k = 0;

        int[] f = fibonacci();
        // 获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        // 因为f[k]值可能大于a的长度，我们需要构造新的数组
        int[] temp = Arrays.copyOf(arr, f[k]);

        // 用原数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] + 1;
            if (findVal < temp[mid]) {
                high = mid - 1;
                // 全部元素 = 前面的元素 + 后边的元素
                // f[k] = f[k - 1] + f[k - 2]
                // 因为前半部分有f[k - 1]个元素，所有k = k - 1
                k--;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                // 全部元素 = 前面的元素 + 后边的元素
                // f[k] = f[k - 1] + f[k - 2]
                // 因为后半部分有f[k - 2]个元素，所有k = k - 2
                k -= 2;
            } else {
                return mid < high ? mid : high;
            }
        }
        return -1;
    }

    private static int[] fibonacci() {
        int maxSize = 20;
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
