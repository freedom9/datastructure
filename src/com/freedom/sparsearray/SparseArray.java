package com.freedom.sparsearray;

/**
 * 稀疏数组：第一部分（第一行）记录的是原数组的行数和列数以及有效数据的个数；
 *           第二部分（从第二行开始）记录的是原数组中元素的位置和内容。
 * @author freedom
 * @date 2020/8/4 20:25
 */
public class SparseArray {

    public static void main(String[] args) {

        // 0：表示没棋子  1：表示黑子  2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][4] = 1;

        int[][] sparseArr = arrayToSparseArray(chessArr);

        System.out.println("----------------稀蔬数组----------------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        int[][] resumeChess = sparseArrayToArray(sparseArr);

        System.out.println("----------------恢复的数组----------------");
        for (int[] row : resumeChess) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 数组转稀疏数组
     * 1、遍历原始的二维数组，得到有效数据的个数sum
     * 2、根据sum就可以创建稀疏数组sparseArr int[sum + 1][3]
     * 3、将二维数组的有效数据存入到稀疏数组
     *
     * @param chessArr 数组
     * @return
     */
    private static int[][] arrayToSparseArray(int[][] chessArr) {
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        return sparseArr;
    }

    /**
     * 稀疏数组转数组
     * 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
     * 2、再读取稀疏数组后几行数据，并赋给原始的二维数组即可
     *
     * @param sparseArr 稀疏数组
     * @return
     */
    private static int[][] sparseArrayToArray(int[][] sparseArr) {
        int[][] resumeChess = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i <  sparseArr.length; i++) {
            resumeChess[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return resumeChess;
    }
}
