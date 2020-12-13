package com.freedom.recursion;

/**
 * @author freedom
 * @date 2020/8/31 20:41
 */
public class Queen8 {

    // 皇后的个数
    private static final int QUEEN_NUMBER = 8;

    // 定义数组array，保存皇后放置位置的结果，比如array = {0, 4, 7, 5, 2, 6, 1. 3}
    // array下标表示第几行，即第几个皇后，array[i] = val，表示第i + 1个皇后，放在第i + 1行的第val + 1列
    static int[] array = new int[QUEEN_NUMBER];

    // 统计总共有几种摆放
    private static int count = 0;

    public static void main(String[] args) {

        placeQueen(0);
        System.out.printf("一共有%d解法", count);
    }

    /**
     * 摆放皇后
     *
     * @param n 第几个皇后
     */
    private static void placeQueen(int n) {
        if (n == QUEEN_NUMBER) {
            print();
            return;
        }

        for (int i = 0; i < QUEEN_NUMBER; i++) {
            array[n] = i;
            // 判断放置的位置是否和之前的放置的皇后冲突
            if (conflict(n)) {
                placeQueen(n + 1);
            }
        }
    }

    /**
     * 判断是否和之前放置的皇后冲突
     *
     * @param n
     * @return
     */
    private static boolean conflict(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 判断第n个皇后是否和前面的n - 1个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] = array[i]) 判断第n个皇后是否和前面的n - 1个皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        count++;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
