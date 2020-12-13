package com.freedom.graph;

/**
 * @author freedom
 * @date 2020/11/23 20:59
 */
public class GraphTest {

    public static void main(String[] args) {
        String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H"};

        Graph graph = new Graph(vertexs.length);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        // 添加边 A-B
        graph.insertEdge(0, 1);
        // A-C
        graph.insertEdge(0, 2);
        // B-D
        graph.insertEdge(1, 3);
        // B-E
        graph.insertEdge(1, 4);
        // C-F
        graph.insertEdge(2, 5);
        // C-G
        graph.insertEdge(2, 6);
        // D-H
        graph.insertEdge(3, 7);
        // E-H
        graph.insertEdge(4, 7);

        graph.showGraph();

        System.out.println("深度遍历：");
        graph.dfs();// A—>B—>D—>H—>E—>C—>F—>G

        System.out.println();
        System.out.println("广度遍历：");
        graph.bfs();// A—>B—>C—>D—>E—>F—>G—>H
    }
}
