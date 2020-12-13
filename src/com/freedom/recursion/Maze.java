package com.freedom.recursion;

/**
 * @author freedom
 * @date 2020/8/30 21:28
 */
public class Maze {

    /**
     * 0：代表没走过
     * 1：代表墙
     * 2、代表该点的路能走通
     * 3：代表该店的路不能走通
     */
    private static final int NEVER_WALKED = 0;
    private static final int WALL = 1;
    private static final int ROAD_THROUGH = 2;
    private static final int ROAD_NOT_THROUGH = 3;


    public static void main(String[] args) {

        // 创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];

        // 上下全部置为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = WALL;
            map[7][i] = WALL;
        }

        // 左右全部置为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = WALL;
            map[i][6] = WALL;
        }

        // 设置挡板
        map[3][1] = WALL;
        map[3][2] = WALL;
        map[2][2] = WALL;

        System.out.println("地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("小球走过，并标识过的地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 约定：
     * 1、从开始位置map[1][1]能到结束位置map[6][5]，代表路找到了；
     * 2、走的策略“下 -> 右 -> 上 -> 左”，如果该点走不通，再回溯。
     *
     * @param map 地图
     * @param i   开始位置
     * @param j
     * @return
     */
    private static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == ROAD_THROUGH) {
            return true;
        }

        if (map[i][j] == NEVER_WALKED) {
            map[i][j] = ROAD_THROUGH;
            if (setWay(map, i + 1, j)) {
                // 向下走
                return true;
            } else if (setWay(map, i, j + 1)) {
                // 向右走
                return true;
            } else if (setWay(map, i - 1, j)) {
                // 向上走
                return true;
            } else if (setWay(map, i, j - 1)) {
                // 向左走
                return true;
            } else {
                // 此路不通
                map[i][j] = ROAD_NOT_THROUGH;
                return false;
            }
        }
        return false;
    }
}
