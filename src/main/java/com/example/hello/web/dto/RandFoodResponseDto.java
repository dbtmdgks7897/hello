package com.example.hello.web.dto;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.search.TbSearch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RandFoodResponseDto {
    private Long id;
    private String name;
    private String img;

    public RandFoodResponseDto(TbFood entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.img = entity.getImg();
    }
}
