package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Member extends Dto {
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
