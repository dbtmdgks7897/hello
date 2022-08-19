package com.example.hello.web.dto;

import com.example.hello.domain.food.TbFood;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovieRankResponseDto {
    private int rank;
    private String title;
    private String img;
    private String story;

    public MovieRankResponseDto(int rank, String title, String img, String story) {
        this.rank = rank;
        this.title = title;
        this.img = img;
        this.story = story;
    }
}
