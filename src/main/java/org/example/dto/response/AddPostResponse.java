package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AddPostResponse {
    private String title;
    private String content;
    private String imgUrl;
    private  UserInfoResponse userInfoResponse;
}
