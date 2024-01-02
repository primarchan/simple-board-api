package com.example.simpleboard.reply.repository;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.reply.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    // select * from reply where post_id = ? and status = ? order by id desc;
    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, Status status);

}
