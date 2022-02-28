package com.example.springboot.domain.posts;


import com.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity //테이블과 링크 될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙
    private Long id;

    @Column(length = 500,nullable = false)//테이블의 칼럼을 나타내며 굳이 선언안해도 해당 클래스 필드는 모두 칼럼처리, 쓰는이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을 때
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }



    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
