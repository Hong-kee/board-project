package com.hongki.boardproject.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        //given
        String name = "hongki";
        String nickname = "developer";

        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);

        //then -> static import
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }
}