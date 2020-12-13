package com.freedom.linkedlist;

/**
 * @author freedom
 * @date 2020/8/19 21:37
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {

        DoubleLinkedList.HeroNode hero1 = new DoubleLinkedList.HeroNode(1, "宋江", "及时雨");
        DoubleLinkedList.HeroNode hero2 = new DoubleLinkedList.HeroNode(2, "卢俊义", "玉麒麟");
        DoubleLinkedList.HeroNode hero3 = new DoubleLinkedList.HeroNode(3, "吴用", "智多星");
        DoubleLinkedList.HeroNode hero4 = new DoubleLinkedList.HeroNode(4, "林冲", "豹子头");

        DoubleLinkedList DoubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList.add(hero1);
        DoubleLinkedList.add(hero4);
        DoubleLinkedList.add(hero2);
        DoubleLinkedList.add(hero3);
        DoubleLinkedList.list();


        DoubleLinkedList.HeroNode newHeroNode = new DoubleLinkedList.HeroNode(2, "小卢", "玉麒麟");
        DoubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        DoubleLinkedList.list();

        DoubleLinkedList.delete(2);
        System.out.println("删除后的链表");
        DoubleLinkedList.list();

    }
}
