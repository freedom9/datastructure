package com.freedom.sort;

/**
 * @author freedom
 * @date 2020/9/2 20:28
 */
public class SortTest {

    public static void main(String[] args) {
//        int[] arr = {-99, 53, -3, 542, 748, -48, 14, 214, -23, -56};

//        BubbleSort.bubbleSort(arr);

//        SelectSort.selectSort(arr);

//        InsertSort.insertSort(arr);

//        ShellSort.swapShellSort(arr);

//        ShellSort.shiftShellSort(arr);

//        MergeSort.mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

//        RadixSort.radixSort(arr);

//        CountSort.countSort(arr);

//        BucketSort.bucketSort(arr);

//        QuickSort.quickSort(arr, 0, arr.length - 1);

//        HeapSort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));



        int count = 100000;
        int[] arr = new int[count];
        for (int i = 0; i < count / 2; i++) {
            arr[i] = (int) (Math.random() * count);
        }
        long starTime = System.currentTimeMillis();

        // 100000       11453   11359   11577
//        BubbleSort.bubbleSort(arr);
        // 100000       4812    4640    4625
//        SelectSort.selectSort(arr);
        // 100000       2188    2125    2141
//        InsertSort.insertSort(arr);
        // 100000       11281   11249   10890
//        ShellSort.swapShellSort(arr);
        // 100000       16   32   16
//        ShellSort.shiftShellSort(arr);
        // 100000       32   47   31
//        MergeSort.mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        // 100000       15   32   31
//        RadixSort.radixSort(arr);
        // 100000       15   16   15
//        CountSort.countSort(arr);
        // 100000       94   93   93
//        BucketSort.bucketSort(arr);
        // 10000        31   32   31
        // todo: 100000就栈溢出，这是个问题，待解决
//        QuickSort.quickSort1(arr, 0, arr.length - 1);
        // 100000       16   16   15
        HeapSort.heapSort(arr);
        System.out.printf("排序使用的时间：%d", System.currentTimeMillis() - starTime);
    }
}
