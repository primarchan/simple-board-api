package com.example.simpleboard.reply.service;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.crud.CRUDAbstractService;
import com.example.simpleboard.post.entity.PostEntity;
import com.example.simpleboard.post.repository.PostRepository;
import com.example.simpleboard.reply.entity.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import com.example.simpleboard.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDto, ReplyEntity> {

    /*
    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public ReplyEntity create(ReplyRequest replyRequest) {
        Optional<PostEntity> optionalPostEntity = postRepository.findById(replyRequest.getPostId());

        if (optionalPostEntity.isEmpty()) {
            throw new RuntimeException("게시글이 존재하지 않습니다. 게시글 번호 : " + replyRequest.getPostId());
        }

        ReplyEntity replyEntity = ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status(Status.REGISTERED)
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(replyEntity);
    }

    public List<ReplyEntity> findAllByPostId(Long postId) {

        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, Status.REGISTERED);
    }
     */

}
