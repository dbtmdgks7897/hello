package com.example.hello.domain.search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TbSearchRepository extends JpaRepository<TbSearch, Long> {

    @Query(value = "SELECT * FROM tb_search ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public TbSearch findSearchRand();
}