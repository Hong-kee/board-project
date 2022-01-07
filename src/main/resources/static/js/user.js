/*
ajax를 사용하는 이유
-> 요청에 대한 응답을 .html 파일이 아닌 JSON Data로 받기 위해. 비동기 통신을 하기 위해.
*/
'use strict';

let index = {
    init: function() {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save: function() {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            nickname: $("#nickname").val()
        }

        $.ajax({
            type: "POST", //Http Method
            url: "/api/v1/user", //API 주소
            data: JSON.stringify(data), //JSON으로 변환
            contentType: "application/json; charset=utf-8", // TYPE Set
            dataType: "json" //응답 데이터
        }).done(function(res){
            alert("회원가입이 완료되었습니다.");
            location.href = "/";
        }).fail(function(err) {
            alert(JSON.stringify(err));
        });
    }
}
index.init();