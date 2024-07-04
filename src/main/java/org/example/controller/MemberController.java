package org.example.controller;

import org.example.Util.Util;
import org.example.dto.Member;

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

    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch (actionMethodName) {
            case "join":
                if (isLogined()) {
                    System.out.println("이미 로그인중");
                    return;
                }
                doJoin();
                break;
            case "login":
                if (isLogined()) {
                    System.out.println("이미 로그인중");
                    return;
                }
                doLogin();
                break;
            case "logout":
                if (!isLogined()) {
                    System.out.println("이미 로그아웃 상태");
                    return;
                }
                doLogout();
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
            if (loginChk(loginId) == false ) {
                System.out.println("This ID is already taken");
                continue;
            }
            break;
        }

        String loginPw = null;
        while (true) {
            System.out.print("login Pw : ");
            loginPw = sc.nextLine();
            System.out.print("login Pw Chk : ");
            String loginPwChk = sc.nextLine().trim();

            if (loginPw.equals(loginPwChk) == false) {
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

    private void doLogin() {

        System.out.println("==Member login==");

        System.out.print("login id : ");
        String loginId = sc.nextLine().trim();
        System.out.print("PWD : ");
        String loginPw = sc.nextLine();

        // 회원인가? -> 사용자가 방급 입력한 로그인 아이디랑 일치하는 회원이 있나?
        Member member = getMemberByLoginId(loginId);

        if (member == null) {
            System.out.println("일치하는 회원이 없어");
            return;
        }
        // 있다 -> 이사람이 비번이 일치하는지 판별
        if (member.getLoginPw().equals(loginPw) == false) {
            System.out.println("비번이 일치하지 않아");
            return;
        }

        loginMember = member;
        System.out.printf("%s님 로그인 성공\n", member.getName());

    }

    private void doLogout() {
        loginMember = null;
        System.out.println("로그아웃 되었습니다");
    }


    private boolean loginChk(String loginId) {
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return false;
            }
        }
        return true;
    }

    private Member getMemberByLoginId(String loginId) {
        for (Member member : members) {
            if (member.getLoginId().equals(loginId)) {
                return member;
            }
        }
        return null;
    }

    public void makeTestData() {
        System.out.println("회원 테스트 데이터 생성");

        for (int i = 1; i <= 3; i++) {
            String now = Util.getNow();
            members.add(new Member(i, now, "id" + i, "pw" + i, "user" + i));
        }
    }
}
