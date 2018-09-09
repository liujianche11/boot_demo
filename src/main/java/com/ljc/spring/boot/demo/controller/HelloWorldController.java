package com.ljc.spring.boot.demo.controller;

import com.ljc.spring.boot.demo.config.TempFileConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //使用@Value注入
//    @Value("${temp.file.path}")
//    private String tempFilePath ;

    //使用单独的配置类注入
    @Autowired
    private TempFileConfig tempFileConfig;

    @GetMapping("/say")
    public String say(){
        System.out.println(tempFileConfig.getPath());
        return "hello world";
    }

    //使用@PathVariable获取url中的值
    @GetMapping("/sayname/{name}")
    public String sayName(@PathVariable("name") String name){
        System.out.println(name);
        return name;
    }

    //使用@RequestParam获取参数
    @PostMapping("/sayBye")
    public String sayBye(@RequestParam(value = "name") String name){
        System.out.println(name);
        return name;
    }


}
