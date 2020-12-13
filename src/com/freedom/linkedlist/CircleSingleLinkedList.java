package com.freedom.linkedlist;

/**
 * @author freedom
 * @date 2020/8/19 21:41
 */
public class CircleSingleLinkedList {

    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入的参数错误");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy newBoy = new Boy(i);
            if (i == 1) {
                first = newBoy;
                first.next = first;
                curBoy = first;
                continue;
            }

            curBoy.next = newBoy;
            newBoy.next = first;
            curBoy = newBoy;
        }
    }

    public void showBoys() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号：%d\n", curBoy.getNo());
            if (curBoy.next == first) {
                break;
            }
            curBoy = curBoy.next;
        }
    }

    /**
     * @param startNo 从第几个小孩开始报数
     * @param countNum 数几下
     * @param nums 最初小孩总数
     */
    public void popBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入的参数有误，请重新输入");
            return;
        }

        Boy helper = first;

        // 把辅助节点helper指向first的前一个节点
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 1; i < countNum; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("出列的男孩的编号：%d\n", first.getNo());
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留下的男孩的编号: %d \n", first.getNo());
    }

    public class Boy {

        private int no;

        private Boy next;

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }
    }
}
