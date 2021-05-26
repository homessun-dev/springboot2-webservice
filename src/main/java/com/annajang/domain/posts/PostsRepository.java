package com.annajang.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}


/*
    보통 ibatis나 Mybatis 등에서 DAO라고 불리는 DB Layer 접근자.
    JPA에선 Repository라고 부르며 인터페이스로 생성
    단순히 인터페이스를 생성후 JpaRepository<Entity 클래서, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성됨.
    @Repository를 추가할 필요도 없다.
    Entity 클래스와 기본 Entity Repository는 함께 위치해야한다는 점이 중요!!!
    Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없다.
    프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면 함께 도메인 패키지에서 관리하는게 좋다.

    조회의 경우 FK의 조인, 복잡한 조건으로 Entity클래스 만으로 처리하기 어려워 조회용 프레임워크를 추가로 사용함.
    대표적예로 querydsl, jooq, MyBatis 등이 있음. 3가지 중에 하나를 통해 조회하고 등록/수정/삭제 등은 SpringDataJpa를 통해 진행. querydsl 추천!!
    1. 타입안정성 보장 / 2. 국내 많은 회사에서 사용중 / 3. 레퍼런스가 많음(국내 자료가 많아서 질의응답 가능이 큰 장점)

 */