package com.example.simpleboard.post.service;

import com.example.simpleboard.board.entity.BoardEntity;
import com.example.simpleboard.board.repository.BoardRepository;
import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import com.example.simpleboard.common.Status;
import com.example.simpleboard.post.entity.PostEntity;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.post.repository.PostRepository;
import com.example.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(PostRequest postRequest) {
        BoardEntity boardEntity = boardRepository.findById(postRequest.getBoardId()).get();

        PostEntity postEntity = PostEntity.builder()
                .board(boardEntity)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status(Status.REGISTERED)
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();


        return postRepository.save(postEntity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), Status.REGISTERED).map(it -> {
           if (!it.getPassword().equals(postViewRequest.getPassword())) {
               String format = "패스워드가 맞지 않습니다. %s VS %s";
               throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
           }
            return it;
        }).orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId()));
    }

    public Api<List<PostEntity>> all(Pageable pageable) {

        Page<PostEntity> postEntityList = postRepository.findAll(pageable);

        Pagination pagination = Pagination.builder()
                .page(postEntityList.getNumber())
                .size(postEntityList.getSize())
                .currentElements(postEntityList.getNumberOfElements())
                .totalElements(postEntityList.getTotalElements())
                .totalPage(postEntityList.getTotalPages())
                .build();

        Api<List<PostEntity>> response = Api.<List<PostEntity>>builder()
                .body(postEntityList.toList())
                .pagination(pagination)
                .build();

        return response;
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId()).map(it -> {
            if (!it.getPassword().equals(postViewRequest.getPassword())) {
                String format = "패스워드가 맞지 않습니다. %s VS %s";
                throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
            }
            it.setStatus(Status.UNREGISTERED);
            postRepository.save(it);
            return it;
        }).orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId()));

    }
}
