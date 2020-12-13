package com.freedom.linkedlist;

/**
 * @author freedom
 * @date 2020/8/19 22:14
 */
public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        int nums = 50;
        circleSingleLinkedList.addBoy(nums);
        circleSingleLinkedList.showBoys();

        System.out.println();

        circleSingleLinkedList.popBoy(11, 21, nums);
    }
}
