package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/main")
    public String index(){
        return "Main";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/action_page")
    public String action_page(@RequestParam String search){
        return "입력한 검색어 : " + search;
    }


    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return "Hello " + name;
    }
}
