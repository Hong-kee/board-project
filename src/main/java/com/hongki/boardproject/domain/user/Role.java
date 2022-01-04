package com.hongki.boardproject.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    //Spring Security에선 권한 코드에 항상 ROLE_이 앞에 있어야 한다.
    USER("ROLE_USER", "사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}
