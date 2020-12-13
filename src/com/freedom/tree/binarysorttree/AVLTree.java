package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/17 20:39
 * @description 1、平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又称为AVL树，可以保证查询效率较高。
 *              2、特点：他是一颗空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一颗平衡二叉树。
 *              平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
 */
public class AVLTree {

    private AVLNode root;

    public void addNode(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        }

        AVLNode targetNode = root.searchNode(value);
        if (targetNode == null) {
            return;
        }
        // 查询当前二叉树只有一个根结点
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }

        AVLNode targetParentNode = root.searchParentNode(value);
        // 如果删除的结点是叶子结点
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            // 判断targetNode是父结点的左子结点，还是右子结点
            if (targetParentNode.getLeft() != null && targetNode.getValue() == value) {
                targetParentNode.setLeft(null);
            } else {
                targetParentNode.setRight(null);
            }
            // 删除有两个子树的结点
        } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            int minValue = selectRightMin(targetNode.getRight());
            targetNode.setValue(minValue);
            // 删除只有一个子树的结点
        } else {
            if (targetNode.getLeft() != null) {
                if (targetParentNode != null) {
                    // 如果targetNode是parent的左子结点
                    if (targetParentNode.getLeft().getValue() == value) {
                        targetParentNode.setLeft(targetNode.getLeft());
                    } else {
                        targetParentNode.setRight(targetNode.getLeft());
                    }
                } else {
                    root = targetNode.getLeft();
                }
            } else {
                if (targetParentNode != null) {
                    if (targetParentNode.getLeft().getValue() == value) {
                        targetParentNode.setLeft(targetNode.getRight());
                    } else {
                        targetParentNode.setRight(targetNode.getRight());
                    }
                } else {
                    root = targetNode.getRight();
                }
            }
        }
    }

    /**
     * 查找右子树最小的结点
     *
     * @param node 要删除的结点的右结点
     * @return
     */
    public int selectRightMin(AVLNode node) {
        AVLNode tempNode = node;
        while (tempNode.getLeft() != null) {
            tempNode = tempNode.getLeft();
        }
        delNode(tempNode.getValue());
        return tempNode.getValue();
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public AVLNode getRoot() {
        return root;
    }
}

