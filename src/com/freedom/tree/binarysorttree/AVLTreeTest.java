package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/17 21:00
 */
public class AVLTreeTest {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5,7, 8};

//        int[] arr = {10, 12, 8, 9, 7, 6};

        int[] arr = {10, 11, 7, 6, 8, 9};

        AVLTree avlTree = new AVLTree();
        for (int item : arr) {
            avlTree.addNode(new AVLNode(item));
        }

        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("左子树的高度 = " + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度 = " + avlTree.getRoot().rightHeight());
        System.out.println("根结点 = " + avlTree.getRoot());
    }
}
