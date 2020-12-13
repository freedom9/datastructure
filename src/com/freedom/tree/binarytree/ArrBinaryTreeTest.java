package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/20 21:13
 */
public class ArrBinaryTreeTest {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.print("前序顺序二叉树：");
        arrBinaryTree.preOrderTraverse(0);

        System.out.println();

        System.out.print("中序顺序二叉树：");
        arrBinaryTree.inOrderTraverse(0);
    }
}
