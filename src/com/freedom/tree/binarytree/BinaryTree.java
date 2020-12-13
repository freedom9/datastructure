package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/18 21:11
 */
public class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrderTraverse() {
        if (root != null) {
            root.preOrderTraverse();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public void postOrderTraverse() {
        if (root != null) {
            root.postOrderTraverse();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode inOrderSearch(int no) {
        if (root != null) {
            return root.inOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除！");
        }
    }
}
