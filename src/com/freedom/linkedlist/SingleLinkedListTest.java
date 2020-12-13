package com.freedom.linkedlist;

/**
 * @author freedom
 * @date 2020/8/9 21:50
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {

        SingleLinkedList.HeroNode hero1 = new SingleLinkedList.HeroNode(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode hero2 = new SingleLinkedList.HeroNode(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode hero3 = new SingleLinkedList.HeroNode(3, "吴用", "智多星");
        SingleLinkedList.HeroNode hero4 = new SingleLinkedList.HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.list();

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();

//        SingleLinkedList.HeroNode newHeroNode = new SingleLinkedList.HeroNode(2, "小卢", "玉麒麟");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改后的链表");
//        singleLinkedList.list();
//
//        singleLinkedList.delete(2);
//        System.out.println("删除后的链表");
//        singleLinkedList.list();

//        System.out.println("链表个数：" + singleLinkedList.getLength(singleLinkedList.getHead()));
//
//        System.out.println("链表的到时第2个节点：" + singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 2));

        singleLinkedList.reverseList(singleLinkedList.getHead());
        System.out.println("反转后的链表");
        singleLinkedList.list();

//        System.out.println("逆序打印的链表");
//        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }
}
