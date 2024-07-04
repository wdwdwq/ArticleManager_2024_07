package org.example.system;

import org.example.controller.ArticleController;
import org.example.controller.Controller;
import org.example.controller.MemberController;

import java.util.Scanner;

public class App{
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==Article Start==");

        MemberController memberController = new MemberController(sc);
        ArticleController articleController = new ArticleController(sc);

        articleController.makeTestData();
        memberController.makeTestData();

        Controller controller = null;


        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("Enter the command");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }

            String[] cmdBits = cmd.split(" ");

            String controllerName = cmdBits[0];

            if (cmdBits.length == 1) {
                System.out.println("Please check the command");
                continue;
            }

            String actionMethodName = cmdBits[1];

            String forLoginCHK = controllerName + "/" + actionMethodName;

            switch (forLoginCHK) {
                case "article/write":
                case "article/delete":
                case "article/modify":
                case "member/logout":
                    if(Controller.isLogined() == false){
                        System.out.println("로그인 필요");
                        continue;
                    }
                    break;
            }

            switch (forLoginCHK){
                case "member/login":
                case "member/join":
                    if(Controller.isLogined()){
                    System.out.println("로그아웃 필요");
                        continue;
                    }
                    break;
            }

            if (controllerName.equals("article")) {
                controller = articleController;
            } else if (controllerName.equals("member")) {
                controller = memberController;
            } else {
                System.out.println("Command is wrong");
                continue;
            }

            controller.doAction(cmd, actionMethodName);

        }

        System.out.println("== Article exit ==");

        sc.close();
    }
}
