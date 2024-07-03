package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String regDate;
    private String loginId;
    private String loginPw;
    private String name;
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
