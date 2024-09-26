package com.itheima.system;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        String id;
        loop:
        while (true) {
            System.out.println("-------------欢迎来到黑马学生管理系统----------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            String chooes = sc.next();
            switch (chooes) {
                case "1":
                    Add(list);
                    break;
                case "2":
                    System.out.println("id:");
                    id = sc.next();
                    Delete(list, id);
                    break;
                case "3":
                    System.out.println("id:");
                    id = sc.next();
                    Change(list, id);
                    break;
                case "4":
                    Inquire(list);
                    break;
                default:
                    break loop;//另一种写法：system.exit(0)停止虚拟机运行
            }
        }


    }

    //添加功能
    public static void Add(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        boolean ret = true;
        String sid;
        System.out.print("id:");
        sid = sc.next();
        s.setId(sid);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)){
                ret = false;
            }
        }
        if (ret) {
            System.out.print("姓名:");
            s.setName(sc.next());
            System.out.print("年龄:");
            s.setAge(sc.nextInt());
            System.out.print("家庭地址:");
            s.setAddress(sc.next());
            list.add(s);
            System.out.println("添加完成");
        } else {
            System.out.println("id不唯一");
        }
    }

    //删除功能
    public static void Delete(ArrayList<Student> list, String id) {
        boolean ret = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("删除完成");
                ret = false;
            }
            if (ret) {
                System.out.println("不存在");
            }
        }
    }

    //修改功能
    public static void Change(ArrayList<Student> list, String id) {
        Scanner sc = new Scanner(System.in);
        String sid;
        String sname;
        int sage;
        String saddress;
        boolean ret = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.print("id:");
                sid = sc.next();
                System.out.print("姓名:");
                sname = sc.next();
                System.out.print("年龄:");
                sage = sc.nextInt();
                System.out.print("家庭地址:");
                saddress = sc.next();
                list.get(i).setId(sid);
                list.get(i).setName(sname);
                list.get(i).setAge(sage);
                list.get(i).setAddress(saddress);
                System.out.println("修改完成");
                ret = false;
            }
            if (ret) {
                System.out.println("不存在");
            }
        }
    }

    //查询功能
    public static void Inquire(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息，请添加后查询");
        } else {
            System.out.println("id" + "      " + "姓名" + "      " + "年龄" + "      " + "家庭住址");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId() + "      " + list.get(i).getName() + "      " + list.get(i).getAge() + "      " + list.get(i).getAddress());
            }
        }
    }
}











