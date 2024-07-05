package org.example.system;

import org.example.dao.ArticleDao;
import org.example.dao.MemberDao;
import org.example.dto.Member;
import org.example.service.ArticleService;
import org.example.service.MemberService;

public class Container {
    public static ArticleDao articleDao;
    public static MemberDao memberDao;

    public static ArticleService articleService;
    public static MemberService memberService;

    public static void init() {
        articleDao = new ArticleDao();
        memberDao = new MemberDao();

        memberService = new MemberService();
        articleService = new ArticleService();
    }
}
