package com.example.hello.web;

import com.example.hello.domain.food.TbFood;
import com.example.hello.service.food.FoodService;
import com.example.hello.web.dto.RandFoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;

//    @PostMapping("/api/v1/search")
//    public Long save(@RequestBody SearchSaveRequestDto requestDto){
//        return searchService.save(requestDto);
//    }
//
//    @PostMapping("/api/v1/news")
//    public String searchNaver(@RequestBody SearchSaveRequestDto requestDto){
//        return searchService.news(requestDto);
//    }

    @GetMapping("/api/v1/randfood")
    public RandFoodResponseDto randFood(){
        return foodService.randFood();
    }

}