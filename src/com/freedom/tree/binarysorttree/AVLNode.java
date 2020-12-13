package com.freedom.tree.binarysorttree;

/**
 * @author freedom
 * @date 2020/11/17 20:49
 */
public class AVLNode {

    private int value;

    private AVLNode left;

    private AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 左旋
     */
    private void leftRotate() {
        AVLNode newNode = new AVLNode(value);
        // 把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        // 把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        // 把当前结点的值替换成右子结点的值
        value = right.value;
        // 把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        // 把当前结点的左子树设置成新的结点
        left = newNode;
    }

    /**
     * 右旋
     */
    public void rightRotate() {
        AVLNode newNode = new AVLNode(value);

        newNode.right = right;

        newNode.left = left.right;

        value = left.value;

        left = left.left;

        right = newNode;
    }

    public void addNode(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

        // 当添加完一个结点后，如果右子树的高度 - 左子树的高度 > 1，左旋
        if (rightHeight() - leftHeight() > 1) {
            // 如果它的右子树的左子树的高度大于它的右子树的右子树的高度，先对右子结点进行右旋
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
            }
            leftRotate();
            // 不写return，会继续往下执行
            return;
        }

        // 当添加完一个结点后，如果左子树的高度 - 右子树的高度 > 1，右旋
        if (leftHeight() - rightHeight() > 1) {
            // 如果它的左子树的右子树的高度大于它的左子树的左子树的高度，先对左子结点进行左旋
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 查找希要删除的结点
     *
     * @param value
     * @return
     */
    public AVLNode searchNode(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchNode(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value
     * @return
     */
    public AVLNode searchParentNode(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParentNode(value);
            } else if (this.value <= value && this.right != null) {
                return this.right.searchParentNode(value);
            } else {
                return null;
            }
        }
    }

    public void inOrderTraverse() {
        if (this.left != null) {
            this.left.inOrderTraverse();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrderTraverse();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}
