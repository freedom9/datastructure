package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/18 21:44
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");

        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历：");
//        binaryTree.preOrderTraverse();
//
//        System.out.println("中序遍历：");
//        binaryTree.inOrderTraverse();
//
//        System.out.println("后序遍历：");
//        binaryTree.postOrderTraverse();
//
//        int no = 5;
//        HeroNode resNode = null;
//        System.out.println("前序查询：");
//        resNode = binaryTree.perOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到英雄了，信息为%s。\n", resNode);
//        } else {
//            System.out.printf("没有找到no为%d的英雄！", no);
//        }
//
//        System.out.println("中序查询：");
//        resNode = binaryTree.inOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到英雄了，信息为%s。\n", resNode);
//        } else {
//            System.out.printf("没有找到no为%d的英雄！", no);
//        }
//
//        System.out.println("后序查询：");
//        resNode = binaryTree.postOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到英雄了，信息为%s。\n", resNode);
//        } else {
//            System.out.printf("没有找到no为%d的英雄！", no);
//        }

        System.out.println("删除之前：");
        binaryTree.preOrderTraverse();
        binaryTree.delNode(1);
        System.out.println("删除之后：");
        binaryTree.preOrderTraverse();
    }
}
