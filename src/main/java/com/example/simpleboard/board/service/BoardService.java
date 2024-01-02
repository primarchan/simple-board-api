package com.example.simpleboard.board.service;

import com.example.simpleboard.board.entity.BoardEntity;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.repository.BoardRepository;
import com.example.simpleboard.common.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(BoardRequest boardRequest) {
        BoardEntity boardEntity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status(Status.REGISTERED)
                .build();

        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);

        return boardConverter.toDto(savedBoardEntity);
    }

    public BoardDto view(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).get();

        return boardConverter.toDto(boardEntity);
    }
}
