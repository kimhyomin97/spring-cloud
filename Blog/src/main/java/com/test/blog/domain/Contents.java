package com.test.blog.domain;

import java.sql.Date;

 
import org.springframework.data.annotation.CreatedDate;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contents {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String userid;
    
   
}