package com.example.simpleboard.post.model;

import com.example.simpleboard.board.entity.BoardEntity;
import com.example.simpleboard.common.Status;
import com.example.simpleboard.reply.entity.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    private Long id;

    private Long boardId;  // board + _id

    private String userName;

    private String password;

    private String email;

    private Status status;

    private String title;

    private String content;

    private LocalDateTime postedAt;

}
