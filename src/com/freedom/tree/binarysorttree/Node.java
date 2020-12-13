package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/14 20:42
 */
public class Node {

    private int value;

    private Node left;

    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
    }

    /**
     * 查找希要删除的结点
     *
     * @param value
     * @return
     */
    public Node searchNode(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchNode(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value
     * @return
     */
    public Node searchParentNode(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParentNode(value);
            } else if (this.value <= value && this.right != null){
                return this.right.searchParentNode(value);
            } else {
                return null;
            }
        }
    }

    public void inOrderTraverse() {
        if (this.left != null) {
            this.left.inOrderTraverse();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrderTraverse();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
