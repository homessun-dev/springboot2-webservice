package com.annajang.domain.posts;

import com.annajang.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter메서드를 자동생성
@NoArgsConstructor // 기본 생성자 자동 추가 / public Posts(){}와 같은 효과
@Entity // 테이블과 링크될 클래스임을 나타냄 / 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK필드 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙 / 스프링부트 2.0버전부터 generationType.IDENTITY 옵션 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨. / 기본 값 외에 추가로 변경이 필요한 옵션이 있으면 사용. 문자열의 경우 VARCHAR(255)가 기본값, 사이즈 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶은 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성 / 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}


/*
    Setter 메소드가 없다는 점.
    자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는데 이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지
    코드상으로 명확하게 구분할 수 없어 차후 기능 변경시 정말 복잡해짐.
    Entity 클래스에서는 절대 Setter메소드를 만들지 않는다.
    Posts 클래스 생성이 끝났으면 Posts클래스로 Database를 접근하게 해줄 JpaRepository를 생성
 */