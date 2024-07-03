package org.example.controller;

import org.example.Controller;
import org.example.Util;
import org.example.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController extends Controller {
    private Scanner sc;
    private List<Member> members;
    private String cmd;

    private int lastMemberId = 3;

    public MemberController(Scanner sc) {
        this.sc = sc;
        members = new ArrayList<>();
    }
    public void doAction(String cmd, String actionMethodName){
        this.cmd = cmd;

        switch(actionMethodName){
            case "join":
                doJoin();
                break;
            default:
                System.out.println("명령어 확인 (actionMethodName) 오류");
                break;
        }
    }

    private void doJoin() {
        System.out.println("==Member joined==");
        int id = lastMemberId + 1;
        String regDate = Util.getNow();
        String loginId = null;

        while (true) {
            System.out.print("login ID : ");
            loginId = sc.nextLine().trim();
            if (!loginChk(loginId)) {
                System.out.println("This ID is already taken");
                continue;
            }
            break;
        }

        String loginPw = null;
        while (true) {
            System.out.print("login Pw : ");
            loginPw = sc.nextLine().trim();
            System.out.print("login Pw Chk : ");
            String loginPwChk = sc.nextLine().trim();

            if (!loginPw.equals(loginPwChk)) {
                System.out.println("Check your password again please!!!");
                continue;
            }
            break;
        }

        System.out.print("name : ");
        String name = sc.nextLine().trim();

        Member member = new Member(id, regDate, loginId, loginPw, name);
        members.add(member);

        System.out.println(id + " Member number has been registered");
        lastMemberId++;
    }

    private boolean loginChk(String loginId) {
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    public void makeTestData() {
        System.out.println("회원 테스트 데이터 생성");

        for (int i = 1; i <= 3; i++) {
            String now = Util.getNow();
            members.add(new Member(i, now, "id" + i, "pw" + i, "user" + i));
        }
    }
}
