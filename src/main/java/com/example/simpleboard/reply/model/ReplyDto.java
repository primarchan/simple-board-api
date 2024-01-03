package com.example.simpleboard.reply.model;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.post.entity.PostEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private Long id;

    private Long postId;

    private String userName;

    private String password;

    private Status status;

    private String title;

    private String  content;

    private LocalDateTime repliedAt;

}
