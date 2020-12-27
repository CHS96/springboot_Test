package com.hanseul.book.springboot.domain.posts;


import com.hanseul.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메서드 생성
@NoArgsConstructor //기본 생성자 자동 추가, public Posts(){}와 같은 효과
@Entity //테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙
    private Long id;

    /*
        Column 을 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼
        사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 피륻만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
