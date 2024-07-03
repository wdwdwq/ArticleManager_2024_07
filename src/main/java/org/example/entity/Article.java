package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String regDate;
    private String updateDate;
    private String title;
    private String body;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
