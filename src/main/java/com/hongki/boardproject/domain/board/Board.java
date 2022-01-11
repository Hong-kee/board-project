package com.hongki.boardproject.domain.board;

import com.hongki.boardproject.domain.BaseTimeEntity;
import com.hongki.boardproject.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터를 저장할 때 사용한다.
    private String content;

    private int count; //조회수

    /**
     * @ManyToOne - 게시글을 작성할 때 누가 작성했는지 알아야한다.
     * 따라서 User 테이블과 조인해야한다. Java코드로 객체 선언하면 ORM문법으로 알아서 조인해준다.
     * 즉, id값이 서로 있으니까 id값으로 foreign키를 생성하는 것것     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId") //foreign키 컬럼명 설정
    private User user;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
