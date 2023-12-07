package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddPostRequest {
    private String title;
    private String content;
    private String imgUrl;
    private long userId;
}
