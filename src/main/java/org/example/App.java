package org.example;

import org.example.controller.ArticleController;
import org.example.controller.MemberController;

import java.util.Scanner;

public class App {


    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== Article start ==");

        MemberController memberController = new MemberController(sc);
        ArticleController articleController = new ArticleController(sc);

        articleController.articleTest();
        memberController.memberTest();

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("!!!!! Please enter the command !!!!!");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }

            if (cmd.equals("member join")) {
                memberController.doJoin();
            } else if (cmd.equals("article write")) {
                articleController.doWrite();
            } else if (cmd.startsWith("article list")) {
                articleController.showList(cmd);
            } else if (cmd.startsWith("article detail")) {
                articleController.showDetail(cmd);
            } else if (cmd.startsWith("article delete")) {
                articleController.doDelete(cmd);
            }else if (cmd.startsWith("article modify")) {
                articleController.doModify(cmd);
            } else {
                System.out.println("This command does not exist!!!");
            }
        }

        System.out.println("== Article exit ==");

        sc.close();
    }
}
