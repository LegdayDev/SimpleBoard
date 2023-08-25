package com.legday.simpleboard.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter@Setter
@AllArgsConstructor
public class RespDto<T> {
    private HttpStatus code; //HTTP 상태코드
    private String msg; //통신결과 메서드
    private T body;
}
