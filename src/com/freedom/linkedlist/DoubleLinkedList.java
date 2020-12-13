package com.freedom.linkedlist;

/**
 * @author freedom
 * @date 2020/8/19 21:12
 */
public class DoubleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode cur = head.next;
        while (true) {
            if (cur == null) {
                break;
            }
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public void add(HeroNode newHeroNode) {
        HeroNode cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }

        cur.next = newHeroNode;
        newHeroNode.pre = cur;
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法修改");
            return;
        }

        HeroNode cur = head.next;
        boolean flag = false;
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.no == newHeroNode.no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if (flag) {
            cur.name = newHeroNode.name;
            cur.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改！\n", newHeroNode.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode cur = head.next;
        boolean flag = false;
        while (true) {
            if (cur == null) {
                break;
            }

            if (cur.no == no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if (flag) {
            cur.pre.next = cur.next;
            if (cur.next != null) {
                cur.next.pre = cur.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    public static class HeroNode {
        private int no;

        private String name;

        private String nickName;

        private HeroNode pre;

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
