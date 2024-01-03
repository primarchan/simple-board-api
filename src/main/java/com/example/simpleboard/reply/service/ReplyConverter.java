package com.example.simpleboard.reply.service;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.crud.Converter;
import com.example.simpleboard.post.repository.PostRepository;
import com.example.simpleboard.reply.entity.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {

    private final PostRepository postRepository;

    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {

        return ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getPost().getId())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .content(replyEntity.getContent())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {

        var postEntity = postRepository.findById(replyDto.getPostId());

        return ReplyEntity.builder()
                .id(replyDto.getId())
                .post(postEntity.orElseGet(() -> null))
                .status((replyDto.getStatus() != null) ? replyDto.getStatus() : Status.REGISTERED)
                .title(replyDto.getTitle())
                .content(replyDto.getContent())
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .repliedAt((replyDto.getRepliedAt() != null) ? replyDto.getRepliedAt() : LocalDateTime.now())
                .build();
    }

}
