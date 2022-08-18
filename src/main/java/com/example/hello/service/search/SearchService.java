package com.example.hello.service.search;

import com.example.hello.domain.search.TbSearch;
import com.example.hello.domain.search.TbSearchRepository;
import com.example.hello.utils.NaverNewsApi;
import com.example.hello.web.dto.SearchSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final TbSearchRepository tbSearchRepository;

    @Transactional
    public Long save(SearchSaveRequestDto requestDto){
        return tbSearchRepository.save(requestDto.toEntity()).getId();
    }

    public String news(SearchSaveRequestDto requestDto){
        return NaverNewsApi.newsApi(requestDto.getSearch());
    }

    public List<TbSearch> findAll(){
        return tbSearchRepository.findAll();
    }

    public TbSearch findSearchRand(){
        return tbSearchRepository.findSearchRand();
    }
}
