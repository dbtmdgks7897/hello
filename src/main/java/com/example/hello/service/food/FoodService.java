package com.example.hello.service.food;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.food.TbFoodRepository;
import com.example.hello.web.dto.RandFoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final TbFoodRepository tbFoodRepository;

    public List<TbFood> findAll(){
        return tbFoodRepository.findAll();
    }

    public RandFoodResponseDto randFood(){
        return new RandFoodResponseDto(tbFoodRepository.randFood());
    }
}
