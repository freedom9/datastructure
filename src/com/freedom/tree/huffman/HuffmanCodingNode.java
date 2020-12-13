package com.freedom.tree.huffman;

/**
 * @author freedom
 * @date 2020/11/8 20:44
 */
public class HuffmanCodingNode implements Comparable<HuffmanCodingNode> {

    // 存放数据（字符）
    private Byte data;

    // 权值，表示字符出现的次数
    private int weight;

    private HuffmanCodingNode left;

    private HuffmanCodingNode right;

    public HuffmanCodingNode(Byte data, int weight, HuffmanCodingNode left, HuffmanCodingNode right) {
        this.data = data;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanCodingNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanCodingNode left) {
        this.left = left;
    }

    public HuffmanCodingNode getRight() {
        return right;
    }

    public void setRight(HuffmanCodingNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanCodingNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanCodingNode o) {
        return this.weight - o.weight;
    }

    public void preOrderTraversal() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrderTraversal();
        }
        if (this.right != null) {
            this.right.preOrderTraversal();
        }
    }
}
