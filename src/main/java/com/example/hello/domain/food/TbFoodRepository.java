package com.example.hello.domain.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TbFoodRepository extends JpaRepository<TbFood, Long> {
    @Query(value = "SELECT * FROM tb_food ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public TbFood randFood();
}