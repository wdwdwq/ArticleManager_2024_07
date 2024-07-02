package org.example.article.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String title;
    private String body;

    public String toString() {
       return "Article{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", body='" + body + '\'' +
               '}';

    }
}
