package org.example.dto;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Member extends Dto {
    private String loginId;
    private String loginPw;
    private String name;


    public Member(int id, String regDate, String loginId, String loginPw, String name) {
        this.id= id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
    }
}

//@Override
//public String toString() {
//    return "Member{" +
//            "id=" + id +
//            ", regDate='" + regDate + '\'' +
//            ", loginId='" + loginId + '\'' +
//            ", loginPw='" + loginPw + '\'' +
//            ", name='" + name + '\'' +
//            '}';
//}
//}
