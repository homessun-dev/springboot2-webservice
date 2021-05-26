package com.annajang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}

/* Application클래스는 앞으로 만들 프로젝트의 메인 클래스
    @SpringBootApplication 으로 인해 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
    @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야만 함
    main 메소드에서 실행하는 SpringApplication.run으로 인해 내장 was(Wep application Server,웹 애플리케이션 서버)를 실행
    항상 서버에 톰캣을 설치할 필요가 없게 되고 스프링 부트로 만들어진 Jar파일(실행가능한 Java패키징 파일)로 실행하면 됨.
    언제 어디서나 같은 환경에서 스프링 부트를 배포 할 수 있기 때문에.
* */