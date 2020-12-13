package com.freedom.tree.huffman;

/**
 * @author freedom
 * @date 2020/11/8 15:28
 */
public class HuffmanTreeTest {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};

        HuffmanNode root = HuffmanTree.buildHuffmanTree(arr);

        HuffmanTree.preOrderTraversal(root);
    }
}
