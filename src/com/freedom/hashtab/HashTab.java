package com.freedom.hashtab;

/**
 * @author freedom
 * @date 2020/10/13 20:46
 */
public class HashTab {

    private EmpLinkedList[] empLinkedList;

    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
        // 需要初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLikedListNo = hashNum(emp.id);
        empLinkedList[empLikedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLikedListNo = hashNum(id);
        Emp emp = empLinkedList[empLikedListNo].findEmpById(id);

        if (emp != null) {
            System.out.printf("在第%d个链表找到, 雇员信息：%s\n", empLikedListNo + 1, emp.toString());
        } else {
            System.out.println("在哈希表没有找到雇员信息!");
        }
    }

    public void remove(int id) {
        int empLikedListNo = hashNum(id);
        empLinkedList[empLikedListNo].remove(id);
    }

    private int hashNum(int id) {
        return id % size;
    }

    public class EmpLinkedList {
        private Emp head;

        public void add(Emp emp) {
            if (head == null) {
                head = emp;
                return;
            }

            Emp curEmp = head;
            while (true) {
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            curEmp.next = emp;
        }

        public void list(int no) {
            if (head == null) {
                System.out.printf("第%d链表为空\n", no + 1);
                return;
            }

            System.out.printf("第%d链表的信息：", no + 1);
            Emp curEmp = head;
            while (true) {
                System.out.printf("=> id = %d, name = %s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            System.out.println();
        }

        public Emp findEmpById(int id) {
            if (head == null) {
                System.out.println("链表为空");
                return null;
            }

            Emp curEmp = head;
            while (true) {
                if (id == curEmp.id) {
                    break;
                }
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            return curEmp;
        }

        public void remove(int id) {
            Emp curEmp = head;

            if (head != null && head.id == id) {
                head = curEmp.next;
                return;
            }
            // 标识是否找到待删除的节点
            boolean flag = false;

            while (true) {
                if (curEmp == null) {
                    break;
                }
                if (curEmp.next.id == id) {
                    flag = true;
                    break;
                }
                curEmp = curEmp.next;
            }

            if (flag) {
                curEmp.next = curEmp.next.next;
            } else {
                System.out.printf("要删除的雇员id为%d不存在！\n", id);
            }
        }
    }

    public static class Emp {
        public int id;

        public String name;

        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
