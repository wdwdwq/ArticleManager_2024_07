package org.example.dto;


import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Article extends Dto {
    private String updateDate;
    private String title;
    private String body;

    public Article(int id, String regDate, String updateDate, String title, String body) {
        this.id= id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.title = title;
        this.body = body;
    }
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
