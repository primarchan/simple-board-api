package com.example.simpleboard.common;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Integer page;  // 현재 페이지

    private Integer size;  // 페이지 크기

    private Integer currentElements;  // 현재 요소의 수

    private Integer totalPage;  // 전체 페이지 수

    private Long totalElements;  // 전체 요소의 순

}
