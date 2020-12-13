package com.freedom.tree.huffman;

/**
 * @author freedom
 * @date 2020/11/8 15:10
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    // 结点权值
    private int value;

    private HuffmanNode left;

    private HuffmanNode right;

    public HuffmanNode(int value, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode n) {
        return this.value - n.value;
    }

    public void preOrderTraversal() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrderTraversal();
        }
        if (this.getRight() != null) {
            this.getRight().preOrderTraversal();
        }
    }
}
