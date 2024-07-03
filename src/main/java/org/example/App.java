package org.example;

import org.example.controller.ArticleController;
import org.example.controller.MemberController;

import java.util.Scanner;

public class App extends Controller {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==프로그램 시작==");

        MemberController memberController = new MemberController(sc);
        ArticleController articleController = new ArticleController(sc);

        articleController.makeTestData();
        memberController.makeTestData();

        Controller controller = null;


        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력하세요");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }

            String[] cmdBits = cmd.split(" ");

            String controllerName = cmdBits[0];

            if (cmdBits.length == 1) {
                System.out.println("명령어 확인해");
                continue;
            }

            String actionMethodName = cmdBits[1];

            if (controllerName.equals("article")) {
                controller = articleController;
            } else if (controllerName.equals("member")) {
                controller = memberController;
            } else {
                System.out.println("사용불가 명령어");
                continue;
            }

            controller.doAction(cmd, actionMethodName);

//            if (cmd.equals("member join")) {
//                memberController.doJoin();
//            } else if (cmd.equals("article write")) {
//                articleController.doWrite();
//            } else if (cmd.startsWith("article list")) {
//                articleController.showList(cmd);
//            } else if (cmd.startsWith("article detail")) {
//                articleController.showDetail(cmd);
//            } else if (cmd.startsWith("article delete")) {
//                articleController.doDelete(cmd);
//            } else if (cmd.startsWith("article modify")) {
//                articleController.doModify(cmd);
//            } else {
//                System.out.println("This command does not exist!!!");
//            }
        }

        System.out.println("== Article exit ==");

        sc.close();
    }
}
