package com.example.simpleboard.post.repository;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // select * from post where id = ? and status = ? order by id desc limit 1;
    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, Status status);

    public List<PostEntity> findAllByStatus(Status status);

}
