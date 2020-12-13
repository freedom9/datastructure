package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/29 20:48
 */
public class ThreadedBinaryTree {

    private HeroNode root;

    // 为了实现线索化，需要创建给指向当前结点的指针
    // 在递归进行线索化时，pre总是保留前一个结点
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 对二叉树进行前序线索化
     *
     * @param node
     */
    public void preOrderThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        // 处理当前结点的前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(HeroNode.PRECURSOR_NODE);
        }

        // 处理后继结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(HeroNode.SUCCESSOR_NODE);
        }
        pre = node;

        if (node.getLeftType() != HeroNode.PRECURSOR_NODE) {
            preOrderThreadedNodes(node.getLeft());
        }

        if (node.getRightType() != HeroNode.SUCCESSOR_NODE) {
            preOrderThreadedNodes(node.getRight());
        }
    }

    /**
     * 对二叉树进行中序线索化
     *
     * @param node
     */
    public void inOrderThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        // 先线索化左子树
        inOrderThreadedNodes(node.getLeft());

        // 处理当前结点的前驱结点
        if (node.getLeft() == null) {
            // 让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            // 修改当前结点的左指针的类型，指向前驱结点
            node.setLeftType(HeroNode.PRECURSOR_NODE);
        }

        // 处理后继结点
        if (pre != null && pre.getRight() == null) {
            // 让前驱结点的右指针指向当前结点
            pre.setRight(node);
            // 修改前驱结点的右指针类型，指向后继结点
            pre.setRightType(HeroNode.SUCCESSOR_NODE);
        }

        // 没处理一个结点后，让当前结点时下一个结点的前驱结点
        pre = node;

        // 最后线索化右子树
        inOrderThreadedNodes(node.getRight());
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void preOrderThreadedTraverse() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == HeroNode.LEFT_SUBTREE) {
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            node = node.getRight();
        }
    }

    /**
     * 中序遍历线索化二叉树
     */
    public void inOrderThreadedTraverse() {
        HeroNode node = root;
        while (node != null) {
            // 循环的找到leftType == 1的结点，因为当leftType == 1时，说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == HeroNode.LEFT_SUBTREE) {
                node = node.getLeft();
            }

            System.out.println(node);

            // 如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == HeroNode.PRECURSOR_NODE) {
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的结点
            node = node.getRight();
        }
    }
}
