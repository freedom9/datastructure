package com.freedom.linkedlist;


import java.util.Stack;

/**
 * @author freedom
 * @date 2020/8/9 20:42
 * @deprecation 单链表的实现
 */
public class SingleLinkedList {

    // 头节点，不存放具体数据
    private HeroNode head = new HeroNode(0, null, null);

    public void add(HeroNode node) {
        // head节点不能动，因此我们需要一个赋值遍历
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * 按照编号排名插入
     * @param node
     */
    public void addByOrder(HeroNode node) {
        // 因为是单链表，因此我们找的temp应该是位于添加位置的前一个节点
        HeroNode temp = head;
        // 标识编号是否存在
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            // 位置找到，就在temp的后面插入
            // 因为链表已经按照no排序，所以只要no大于当前插入的no就找到了
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入！\n", node.no);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 根据no编号来修改节点信息
     * @param node
     */
    public void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        // 标识是否找到节点
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改！\n", node.no);
        }
    }

    public void delete(int no) {
        HeroNode temp = head;
        // 标识是否找到待删除的节点
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在！\n", no);
        }
    }

    public HeroNode getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     *
     * @param head 头节点
     * @return 链表的有效个数
     */
    public int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }

        int length = 0;

        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     *
     * @param head
     * @param index
     * @return 单链表中的倒数第k个节点
     */
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        int size = getLength(head);

        if (index <= 0 || index > size) {
            return null;
        }

        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 单链表反转
     *
     * @param head
     */
    public void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next;
            // 将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;
    }

    /**
     * 单链表的逆序打印
     *
     * @param head
     */
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static class HeroNode {

        private int no;

        private String name;

        private String nickName;

        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
