package com.example.simpleboard.board.entity;

import com.example.simpleboard.common.Status;
import com.example.simpleboard.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity(name = "board")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Where(clause = "status = 'REGISTERED'")
    @OrderBy(clause = "id desc")
    @OneToMany(mappedBy = "board")
    @Builder.Default
    private List<PostEntity> postList = List.of();

}
