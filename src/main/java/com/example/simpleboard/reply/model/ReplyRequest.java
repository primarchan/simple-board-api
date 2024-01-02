package com.example.simpleboard.reply.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequest {

    @NotNull
    private Long postId;

    @NotBlank
    private String userName;

    @Size(min = 4, max = 4)
    @NotBlank
    private String password;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
