package com.freedom.hashtab;

import java.util.Scanner;

/**
 * @author freedom
 * @date 2020/10/13 21:24
 */
public class HashTabTest {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("remove：删除雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.print("输入id：");
                    int id = scanner.nextInt();
                    System.out.print("输入名字：");
                    String name = scanner.next();

                    HashTab.Emp emp = new HashTab.Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.print("请输入要查找的id：");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "remove":
                    System.out.print("请输入要删除的id：");
                    id = scanner.nextInt();
                    hashTab.remove(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
