package com.freedom.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author freedom
 * @date 2020/11/23 20:59
 */
public class Graph {

    private static final int SIDE = 1;

    // 存储顶点集合
    private List<String> vertexList;
    // 存储对应的邻结矩阵
    private int[][] edges;
    // 表示边的数目
    private int numOfEdges;
    // 记录某个结点是否被访问
    private boolean[] isVisited;

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
    }

    /**
     * 返回结点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1 表示第几个顶点
     * @param v2 表示第二个顶点对应的下标
     */
    public void insertEdge(int v1, int v2) {
        edges[v1][v2] = SIDE;
        edges[v2][v1] = SIDE;
        numOfEdges++;
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void dfs() {
        isVisited = new boolean[getNumOfVertex()];
        // 遍历所有结点
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 深度优先遍历算法（Depth First Search）
     * 1、访问初始结点v，并标记结点v为已访问
     * 2、查找结点v的第一个邻接结点w
     * 3、若w存在，则继续执行步骤4，如果w不存在，则回到步骤1，将从v的下一个结点继续
     * 4、查找结点v的w邻接结点的下一个邻接结点，转到步骤3
     *
     * @param isVisited
     * @param i
     */
    private void dfs(boolean[] isVisited, int i) {
        System.out.print(vertexList.get(i) + "—>");
        // 设置已访问
        isVisited[i] = true;

        int w = getFirstNeighbor(i);

        while (w != -1) {
            // 如果w结点没有被访问
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void bfs() {
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历算法（Broad First Search）
     * 1、访问初始结点v并标记结点v为已访问
     * 2、结点v入队列
     * 3、当队列非空时，继续执行，否则算法结束
     * 4、出队列，取得对头结点u
     * 5、查找结点u地第一个邻接结点w
     * 6、若结点u得邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     *     6.1 若结点w尚未被访问，则访问结点w并标记为已访问
     *     6.2 结点w入队列
     *     6.3 查找结点u得继w邻接结点后得下一个邻接结点w，转到步骤6
     *
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited, int i) {
        // 表示队列的头结点对应下标
        int u;
        // 邻接结点
        int w;
        // 记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList();

        System.out.print(vertexList.get(i) + "—>");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);

            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(vertexList.get(w) + "—>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1 前一个结点
     * @param v2 前一个邻接结点
     * @return
     */
    private int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < getNumOfVertex(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取第一个邻接结点的下标
     *
     * @param index
     * @return
     */
    private int getFirstNeighbor(int index) {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return 0;
    }
}
