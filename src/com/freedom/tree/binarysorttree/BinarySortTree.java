package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/14 20:42
 */
public class BinarySortTree {

    private Node root;

    public void addNode(Node node) {
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

        Node targetNode = root.searchNode(value);
        if (targetNode == null) {
            return;
        }
        // 查询当前二叉树只有一个根结点
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }

        Node targetParentNode = root.searchParentNode(value);
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
    public int selectRightMin(Node node) {
        Node tempNode = node;
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
}
