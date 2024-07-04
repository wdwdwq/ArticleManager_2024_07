package org.example.system;

import org.example.dao.ArticleDao;
import org.example.dao.MemberDao;
import org.example.dto.Member;

public class Container {
    public static ArticleDao articleDao;
    public static MemberDao memberDao;

    static {
        articleDao = new ArticleDao();
        memberDao = new MemberDao();
    }
}
