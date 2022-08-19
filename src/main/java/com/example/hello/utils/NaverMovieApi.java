package com.example.hello.utils;

import com.example.hello.web.dto.MovieRankResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NaverMovieApi {
    public static List<MovieRankResponseDto> movie(){
        List<MovieRankResponseDto> list = new ArrayList<MovieRankResponseDto>();
        String URL = "https://movie.naver.com/movie/sdb/rank/rmovie.naver";
        Document doc= null;
        String title;
        String imgSrc;
        try {
            doc = Jsoup.connect(URL).get();
            Elements movieList = doc.select(".tit3 > a");
            int i = 0;
            for (Element e : movieList) {
//                System.out.println(e.attr("title"));
//                System.out.println(e.attr("href"));
                title = e.text();
                String code = e.attr("href");
                String [] codeArr = code.split("=");
                URL = "https://movie.naver.com/movie/bi/mi/basic.naver?code=" + codeArr[1];
                doc = Jsoup.connect(URL).get();
                String story = doc.select(".story_area > p").text();

//                System.out.println("https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=" + codeArr[1]);
                URL = "https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=" + codeArr[1];
                doc = Jsoup.connect(URL).get();
                Elements img = doc.select("#targetImage");
                imgSrc = img.attr("src");

                if (i >= 9) break;
                list.add(new MovieRankResponseDto(i++ + 1, title, img.attr("src"), story));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }
}

