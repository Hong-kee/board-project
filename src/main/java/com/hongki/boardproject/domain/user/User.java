package com.hongki.boardproject.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor //생성자
@NoArgsConstructor //빈 생성자
@Entity //User 클래스의 인스턴스들이 JPA로 관리되는 Entity객체를 의미. 즉, 테이블이다.
public class User {

    @Id
    //PK를 자동으로 생성할 때 사용. 즉, auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //아이디 번호 (Primary Key)

    @Column(nullable = false, length = 30)
    private String username; //유저명

    @Column(nullable = false, length = 100)
    private String password; //비밀번호

    @Column(nullable = false, length = 50)
    private String email; //이메일

    @Column(nullable = false, length = 50)
    private String nickname; //닉네임

    //JPA로 DB에 저장할 때 Enum 값을 어떤 형태로 저장할지 결정한다.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
