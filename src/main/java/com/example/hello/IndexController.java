package com.example.hello;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.search.TbSearch;
import com.example.hello.service.food.FoodService;
import com.example.hello.service.search.SearchService;
import com.example.hello.utils.NaverMovieApi;
import com.example.hello.web.dto.MovieRankResponseDto;
import com.example.hello.web.dto.RandFoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final SearchService searchService;
    private final FoodService foodService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/searchlist")
    public String searchList(Model model){
        List<TbSearch> list = searchService.findAll();
        model.addAttribute("slist", list);
        return "searchlist";
    }

    @GetMapping("/foodlist")
    public String foodList(Model model){
        List<TbFood> list = foodService.findAll();
        model.addAttribute("flist", list);
        return "foodlist";
    }

    @GetMapping("/randfood")
    public String randFood(Model model){
        RandFoodResponseDto dto = foodService.randFood();
        model.addAttribute("randomFood", dto);
        return "foodran";
    }

    @GetMapping("movie")
    public String movie(Model model){
        List<MovieRankResponseDto> list = NaverMovieApi.movie();
        model.addAttribute("movieList", list);
        return "movie";
    }
}
