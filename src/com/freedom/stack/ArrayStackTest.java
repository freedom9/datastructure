package com.freedom.stack;

import java.util.Scanner;

/**
 * @author freedom
 * @date 2020/8/23 21:29
 */
public class ArrayStackTest {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(4);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("show: 显示栈");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("exit: 退出程序");

            System.out.println("请输入你得选择：");
            key = scanner.next();

            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    try {
                        stack.push(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.printf("出栈得数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
