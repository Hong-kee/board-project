package com.hongki.boardproject.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 위 추상 클래스는 모든 Entity의 상위 클래스가 되어서 Entity들의 날짜 필드를 자동으로 관리
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //생성할 때 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate //수정할 때 자동저장
    private LocalDateTime modifiedDate;
}
