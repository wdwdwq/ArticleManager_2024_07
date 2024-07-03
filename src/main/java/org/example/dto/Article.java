package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Article extends Dto {
    private int id;
    private String regDate;
    private String updateDate;
    private String title;
    private String body;

}

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", regDate='" + regDate + '\'' +
//                ", updateDate='" + updateDate + '\'' +
//                ", body='" + body + '\'' +
//                '}';
//    }
//}
