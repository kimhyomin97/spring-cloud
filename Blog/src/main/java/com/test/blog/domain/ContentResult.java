package com.test.blog.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentResult {

    private Long id;
    private String userid;
    private String content;
 

    public ContentResult(Contents content) {
        this.id = content.getId();
        this.userid = content.getUserid();
        this.content = content.getContent();
         
    }
}