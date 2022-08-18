package com.example.hello.web;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.search.TbSearch;
import com.example.hello.service.food.FoodService;
import com.example.hello.service.search.SearchService;
import com.example.hello.web.dto.RandFoodResponseDto;
import com.example.hello.web.dto.SearchSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {
    private final SearchService searchService;
    private final FoodService foodService;

    @PostMapping("/api/v1/search")
    public Long save(@RequestBody SearchSaveRequestDto requestDto) {
        return searchService.save(requestDto);
    }

    @PostMapping("/api/v1/news")
    public String searchNaver(@RequestBody SearchSaveRequestDto requestDto) {
        return searchService.news(requestDto);
    }

    @GetMapping("/api/v1/searchrand")
    public TbSearch searchRand() {
        return searchService.findSearchRand();
    }

}
