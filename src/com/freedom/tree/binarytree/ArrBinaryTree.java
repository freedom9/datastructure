package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/20 21:01
 * @description 顺序存储二叉树：从数据存储来看，数组存储方式和树的存储方式可以相互转换。
 * 特点：
 *     1、第n个元素的左子节点为2 * n + 1                               1
 *     2、第n个元素的右子节点为2 * n + 2                             /   \
 *     3、第n个元素的父节点为（n - 1) / 2                           2     3
 *     4、n：表示二叉树中的第几个元素（按0开始编号）              /  \   / \
 *                                                              4    5  6   7
 *                                                         arr: [1, 2, 3, 4, 5, 6, 7]
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树遍历");
        }
        System.out.print(arr[index] + "\t");
        if (index * 2 + 1 < arr.length) {
            preOrderTraverse(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrderTraverse(index * 2 + 2);
        }
    }

    public void inOrderTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树遍历");
        }
        if (index * 2 + 1 < arr.length) {
            inOrderTraverse(index * 2 + 1);
        }
        System.out.print(arr[index] + "\t");
        if (index * 2 + 2 < arr.length) {
            inOrderTraverse(index * 2 + 2);
        }
    }
}
