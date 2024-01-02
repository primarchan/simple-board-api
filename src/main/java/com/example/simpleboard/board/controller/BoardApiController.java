package com.example.simpleboard.board.controller;

import com.example.simpleboard.board.entity.BoardEntity;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(@Valid @RequestBody BoardRequest boardRequest) {

        return boardService.create(boardRequest);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(@PathVariable Long id) {

        return boardService.view(id);
    }

}
