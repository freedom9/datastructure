package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/29 21:15
 */
public class ThreadedBinaryTreeTest {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        /**
         *              1
         *            /   \
         *          3      6
         *        /  \   /
         *       8   10  14
         */
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.preOrderThreadedNodes(root);

//        threadedBinaryTree.inOrderThreadedNodes(root);

        System.out.printf("10号结点的前驱结点是 = %s\n", node5.getLeft());
        System.out.printf("10号结点的后继结点是 = %s\n", node5.getRight());

        System.out.println("使用线索化的前序遍历：");
        threadedBinaryTree.preOrderThreadedTraverse();

//        System.out.println("使用线索化的中序遍历：");
//        threadedBinaryTree.inOrderThreadedTraverse();
    }
}
