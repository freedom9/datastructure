package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/20 21:09
 */
public class CountSort {

    public static void countSort(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        // 辅助空间，数组中的指针存的arr的值，元素为目标数组值得个数
        int[] temp = new int[maxValue - minValue + 1];

        for (int i = 0; i < arr.length; i++) {
            // 可解决负数得情况
            temp[arr[i] - minValue]++;
        }

        // 为了保证排序稳定，需要做一次累计操作
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }

        int[] result = new int[arr.length];

        // 必须从后向前遍历，只有这样出现重复的元素，才会保持顺序的把最后面的重复元素，永远放在最右边
        for (int i = arr.length - 1; i >= 0; i--) {
                int pos = arr[i] - minValue;
                result[temp[pos] - 1] = arr[i];
                temp[pos]--;
        }

        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }
}
