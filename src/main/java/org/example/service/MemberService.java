package org.example.service;

import org.example.dao.MemberDao;
import org.example.dto.Member;
import org.example.system.Container;

import java.util.List;

public class MemberService {
    private MemberDao memberDao;

    public MemberService() {
        memberDao = Container.memberDao;
    }

    public List<Member> getMembers() {
        return memberDao.getMembers();
    }
}
