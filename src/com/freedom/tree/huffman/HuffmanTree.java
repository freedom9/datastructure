package com.freedom.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author freedom
 * @date 2020/11/8 14:59
 * @description 结点的带权路径长度：从根结点到该结点之间的路径长度与该结点的权的乘积。
 *              树的带权路径长度：所有叶子结点的带权路径长度之和，记为WPL（weighted path length），
 *              权值越大的结点离根结点越近的二叉树才是最优二叉树，也称为赫夫曼树。
 */
public class HuffmanTree {

    public static HuffmanNode buildHuffmanTree(int[] arr) {
        List<HuffmanNode> nodeList = new ArrayList<>();

        for (int item : arr) {
            nodeList.add(new HuffmanNode(item, null, null));
        }

        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            HuffmanNode leftNode = nodeList.get(0);
            HuffmanNode rightNode = nodeList.get(1);
            HuffmanNode parentNode = new HuffmanNode(leftNode.getValue() + rightNode.getValue(), leftNode, rightNode);

            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parentNode);
        }
        return nodeList.get(0);
    }

    public static void preOrderTraversal(HuffmanNode root) {
        if (root != null) {
            root.preOrderTraversal();
        } else {
            System.out.println("空树不能遍历！");
        }
    }
}
