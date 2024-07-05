package org.example.controller;

import org.example.Util.Util;
import org.example.dto.Article;
import org.example.dto.Member;
import org.example.service.ArticleService;
import org.example.service.MemberService;
import org.example.system.Container;

import java.util.List;
import java.util.Scanner;

public class ArticleController extends Controller {

    private Scanner sc;
    private List<Article> articles;
    private String cmd;
    private List<Member> members;

    private ArticleService articleService;
    private MemberService memberService;

    private int lastArticleId = 3;

    public ArticleController(Scanner sc) {
        this.articleService = Container.articleService;
        this.memberService = Container.memberService;
        members = memberService.getMembers();
        this.sc = sc;
    }
    public void doAction(String cmd, String actionMethodName){
        this.cmd = cmd;

        switch (actionMethodName){
            case "write":
                doWrite();
                break;
            case "list":
                showList();
                break;
            case "detail":
                showDetail();
                break;
            case "modify":
                doModify();
                break;
            case "delete":
                doDelete();
                break;
            default:
                System.out.println("명령어 확인 (actionMethodName) 오류");
                break;
        }
    }

    private void doWrite() {
        System.out.println("== article write ==");
        int id = lastArticleId + 1;
        String regDate = Util.getNow();
        String updateDate = regDate;
        System.out.print("title : ");
        String title = sc.nextLine();
        System.out.print("body : ");
        String body = sc.nextLine();

        Article article = new Article(id, regDate, updateDate, loginMember.getId(), title, body);

        articleService.add(article);

        System.out.println(id + " This post has been created");
        lastArticleId++;
    }

    private void showList() {
        System.out.println("== article list ==");
        if (articleService.getSize() == 0) {
            System.out.println("there is nothing???");
            return;
        }

        String searchKeyword = cmd.substring("article list".length()).trim();

        List<Article> printArticles = articleService.getForPrintArticles(searchKeyword);

            String writerName = null;

        System.out.println("  id   /    Date    /   User     /   title   /   body   ");
        for (int i = printArticles.size() - 1; i >= 0; i--) {
            Article article = printArticles.get(i);

            for(Member member : members) {
                if(article.getMemberId() == member.getId()) {
                    writerName = member.getName();
                    break;
                }
            }
            if (Util.getNow().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
                System.out.printf("  %d   /   %s    /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[1],writerName,article.getTitle(), article.getBody());
            } else {
                System.out.printf("  %d   /   %s    /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[0],writerName, article.getTitle(), article.getBody());
            }
        }
    }

    private void showDetail() {
        System.out.println("== article detail ==");
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = articleService.getArticleById(id);

        if (foundArticle == null) {
            System.out.printf("Post number %d does not exist\n", id);
            return;
        }

        System.out.printf("id : %d\n", foundArticle.getId());
        System.out.println("ExistingDate : " + foundArticle.getRegDate());
        System.out.println("EditDate : " + foundArticle.getUpdateDate());
        System.out.printf("title : %s\n", foundArticle.getTitle());
        System.out.println("user : " + foundArticle.getMemberId());
        System.out.printf("body : %s\n", foundArticle.getBody());
    }

    private void doDelete() {
        System.out.println("== article delete ==");
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = articleService.getArticleById(id);

        if (foundArticle == null) {
            System.out.printf("Post number %d does not exist\n", id);
            return;
        }

        if(foundArticle.getMemberId() != loginMember.getId()) {
            System.out.println("권한 없음");
            return;
        }

        articles.remove(foundArticle);
        System.out.printf("Post number %d was deleted\n", id);
    }

    private void doModify() {
        System.out.println("==article modify==");

        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = articleService.getArticleById(id);

        if (foundArticle == null) {
            System.out.printf("Post number %d does not exist\n", id);
            return;
        }

        if(foundArticle.getMemberId() != loginMember.getId()) {
            System.out.println("권한 없음");
            return;
        }

        System.out.println("ExistingDate : " + foundArticle.getRegDate());
        System.out.println("EditDate : " + foundArticle.getUpdateDate());
        System.out.println("existing title : " + foundArticle.getTitle());
        System.out.println("existing body : " + foundArticle.getBody());
        System.out.print("Title to edit : ");
        String Ntitle = sc.nextLine();
        System.out.print("Body to edit : ");
        String Nbody = sc.nextLine();

        foundArticle.setTitle(Ntitle);
        foundArticle.setBody(Nbody);
        foundArticle.setUpdateDate(Util.getNow()); // 수정된 시간 업데이트

        System.out.printf("Post number %d has been edited\n", id);


    }

    public void makeTestData() {
        System.out.println("Generating test data");
        for (int i = 1; i <= 3; i++) {
            String now = Util.getNow();
            articleService.add(new Article(i, now, now,1, "제목" + i, "내용" + i));
        }
    }



}
