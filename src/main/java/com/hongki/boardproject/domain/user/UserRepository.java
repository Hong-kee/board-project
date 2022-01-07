package com.hongki.boardproject.domain.user;

//DAO라 불리는 DB 계층 접근자

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {

}
