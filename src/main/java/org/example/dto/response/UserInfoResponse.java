package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserInfoResponse {
    private long id;
    private String username;
    private String email;
    private LocalDateTime createdDate;
}
