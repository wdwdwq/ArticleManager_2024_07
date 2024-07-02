package org.example;

import org.example.article.entity.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==Article start==");

        int lastArticleId = 0;
        List<Article> articles = new ArrayList<>();

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
                System.out.print("title : ");
                String title = sc.nextLine();
                System.out.print("body : ");
                String body = sc.nextLine();

                Article article = new Article(id, title, body);
                articles.add(article);

                System.out.println(id + "This post has been created");
                lastArticleId++;
            } else if (cmd.equals("article list")) {
                System.out.println("==article list==");
                if (articles.size() == 0) {
                    System.out.println("there is nothing???");
                } else {
                    System.out.println("  id   /   title   /   body   ");
                    for (int i = articles.size() - 1; i >= 0; i--) {
                        Article article = articles.get(i);
                        System.out.printf("  %d   /   %s   /   %s  \n", article.getId(), article.getTitle(), article.getBody());
                    }
                }

            } else if (cmd.startsWith("article detail")) {
                System.out.println("==게시글 상세보기==");

                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("Post number %d does not exist\n", id);
                    continue;
                }

                System.out.printf("id : %d\n", foundArticle.getId());
                System.out.printf("title : %s\n", foundArticle.getTitle());
                System.out.printf("body : %s\n", foundArticle.getBody());

            } else if (cmd.startsWith("article modify")) {
                System.out.println("==article modify==");

                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = null;
                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("Post number %d does not exist\n", id);
                    continue;
                }

                System.out.println("existing title : " + foundArticle.getTitle());
                System.out.println("existing body : " + foundArticle.getBody());
                System.out.print("Title to edit : ");
                String Ntitle = sc.nextLine();
                System.out.print("Body to edit : ");
                String Nbody = sc.nextLine();

                foundArticle.setTitle(Ntitle);
                foundArticle.setBody(Nbody);

                System.out.printf("Post number %d has been edited\n", id);

            } else if (cmd.startsWith("article delete")) {
                System.out.println("==article delete==");
                int id = Integer.parseInt(cmd.split(" ")[2]);

                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;
                    }
                }

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


}

