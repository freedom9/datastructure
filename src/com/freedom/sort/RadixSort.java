package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/17 20:52
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }
        // 如果最小值为负数，则数组中的数全部减去最小值，这样能保证数组中最小数是0
        if (minValue < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= minValue;
            }
            // 最大值也需要减，不然可能出现位数发生变化
            maxValue -= minValue;
        }

        int length = String.valueOf(maxValue).length();
        // 表示10个桶
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶实际存放几个数据，比如：bucketElementCount[0]记录着bucket[0]桶放入数据个数
        int[] bucketElementCount = new int[10];

        for (int i = 0, j = 1; i < length; i++, j *= 10) {
            for (int k = 0; k < arr.length; k++) {
                int element = arr[k] / j % 10;
                bucket[element][bucketElementCount[element]] = arr[k];
                bucketElementCount[element]++;
            }

            int index = 0;
            // 遍历每个桶的数量，放入原数组
            for (int n = 0; n < bucketElementCount.length; n++) {
                if (bucketElementCount[n] != 0) {
                    for (int t = 0; t < bucketElementCount[n]; t++) {
                        arr[index++] = bucket[n][t];
                    }
                }
                // 需要把bucketElementCount置为0，不然会出错
                bucketElementCount[n] = 0;
            }
        }

        if (minValue < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += minValue;
            }
        }
    }
}
