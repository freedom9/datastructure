package com.freedom.tree.binarytree;

/**
 * @author freedom
 * @date 2020/10/18 21:11
 */
public class HeroNode {

    private int no;

    private String Name;

    private HeroNode left;

    private HeroNode right;

    public static final int LEFT_SUBTREE = 0;
    public static final int PRECURSOR_NODE = 1;
    public static final int RIGHT_SUBTREE = 0;
    public static final int SUCCESSOR_NODE = 1;

    /**
     * 如果leftType == 0表示指向的时左子树，如果1则表示指向前驱节点
     * 如果leftType == 0表示指向的时右子树，如果1则表示指向后继节点
     */
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        Name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", Name='" + Name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrderTraverse() {
        System.out.println(this);
        if (left != null) {
            left.preOrderTraverse();
        }
        if (right != null) {
            right.preOrderTraverse();
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraverse() {
        if (left != null) {
            left.inOrderTraverse();
        }
        System.out.println(this);
        if (right != null) {
            right.inOrderTraverse();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraverse() {
        if (left != null) {
            left.postOrderTraverse();
        }
        if (right != null) {
            right.postOrderTraverse();
        }
        System.out.println(this);
    }

    /**
     * 前序查询
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (left != null) {
            resNode = left.preOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }
        if (right != null) {
            resNode = right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序查询
     *
     * @param no
     * @return
     */
    public HeroNode inOrderSearch(int no) {
        HeroNode resNode = null;
        if (left != null) {
            resNode = left.inOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }
        if (this.no == no) {
            return this;
        }
        if (right != null) {
            resNode = right.inOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后序查询
     *
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (left != null) {
            resNode = left.postOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }
        if (right != null) {
            resNode = right.postOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 要求：
     * 1、如果删除的节点是叶子节点，则删除该节点；
     * 2、如果删除的节点是非叶子节点，则删除该子数。
     *
     * @param no
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
