package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/14 20:54
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int item : arr) {
            binarySortTree.addNode(new Node(item));
        }

        System.out.println("中序遍历二叉排序树：");
        binarySortTree.inOrderTraverse();

//        binarySortTree.delNode(2);
        binarySortTree.delNode(7);

        System.out.println("删除后遍历：");
        binarySortTree.inOrderTraverse();
    }
}
