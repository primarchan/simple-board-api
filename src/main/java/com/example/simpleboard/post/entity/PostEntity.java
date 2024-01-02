package com.example.simpleboard.post.entity;

import com.example.simpleboard.board.entity.BoardEntity;
import com.example.simpleboard.common.Status;
import com.example.simpleboard.reply.entity.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "post")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board;  // board + _id

    private String userName;

    private String password;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime postedAt;

    @Where(clause = "status = 'REGISTERED'")
    @OrderBy(clause = "id desc")
    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<ReplyEntity> replyList = List.of();

}
