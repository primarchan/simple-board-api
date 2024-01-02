package com.example.simpleboard.common;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private T body;

    private Pagination pagination;

}
