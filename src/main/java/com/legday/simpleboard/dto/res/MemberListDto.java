package com.legday.simpleboard.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter@Setter
public class MemberListDto {
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
