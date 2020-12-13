package com.freedom.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author freedom
 * @date 2020/9/24 21:15
 */
public class BucketSort {

    public static void bucketSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 初始化桶
        int bucketNum = (max - min) / arr.length + 1;
        List<ArrayList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        // 把元素放入对应的桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length;
            bucketList.get(num).add(arr[i]);
        }

        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        // 把元素放入对应的桶
        int index = 0;
        for (ArrayList<Integer> bucket : bucketList) {
            for (Integer element : bucket) {
                arr[index] = element;
                index++;
            }
        }
    }
}
