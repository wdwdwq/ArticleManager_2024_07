package org.example;

import org.example.article.entity.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int lastArticleId = 3; // 클래스 변수로 선언
    static List<Article> articles = new ArrayList<>(); // 클래스 변수로 선언

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==Article start==");

        makeTestData(); // 테스트 데이터 생성

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("!!!!!Please enter the command!!!!!");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }

            if (cmd.equals("article write")) {
                System.out.println("==article write==");
                int id = lastArticleId + 1;
                String regDate = Util.getNow();
                String updateDate = regDate;
                System.out.print("title : ");
                String title = sc.nextLine();
                System.out.print("body : ");
                String body = sc.nextLine();

                Article article = new Article(id, regDate, updateDate, title, body);
                articles.add(article);

                System.out.println(id + " This post has been created");
                lastArticleId++;
            } else if (cmd.equals("article list")) {
                System.out.println("==article list==");
                if (articles.size() == 0) {
                    System.out.println("there is nothing???");
                } else {
                    System.out.println("  id   /    Date    /   title   /   body   ");
                    for (int i = articles.size() - 1; i >= 0; i--) {
                        Article article = articles.get(i);
                        if (Util.getNow().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
                            System.out.printf("  %d   /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[1], article.getTitle(), article.getBody());
                        } else {
                            System.out.printf("  %d   /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[0], article.getTitle(), article.getBody());
                        }

                    }
                }
            } else if (cmd.startsWith("article detail")) {
                System.out.println("==article detail==");

                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("Post number %d does not exist\n", id);
                    continue;
                }

                System.out.printf("id : %d\n", foundArticle.getId());
                System.out.println("ExistingDate : " + foundArticle.getRegDate());
                System.out.println("EditDate : " + foundArticle.getUpdateDate());
                System.out.printf("title : %s\n", foundArticle.getTitle());
                System.out.printf("body : %s\n", foundArticle.getBody());

            } else if (cmd.startsWith("article modify")) {
                System.out.println("==article modify==");

                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("Post number %d does not exist\n", id);
                    continue;
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

            } else if (cmd.startsWith("article delete")) {
                System.out.println("==article delete==");
                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("Post number %d does not exist\n", id);
                    continue;
                }

                articles.remove(foundArticle);
                System.out.printf("Post number %d was deleted\n", id);

            } else {
                System.out.println("This command does not exist!!!");
            }
        }

        System.out.println("== Article exit ==");


        sc.close();
    }

    private static Article getArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private static void makeTestData() {
        System.out.println("테스트 데이터 생성");

        for (int i = 1; i <= 3; i++) {
            String now = Util.getNow();
            articles.add(new Article(++lastArticleId, now, now, "제목" + i, "내용" + i));
        }
    }
}