package com.ljc.spring.boot.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component//需要注册成一个组建
@ConfigurationProperties(prefix = "temp.file")//指定前缀
@PropertySource("classpath:application.properties")//可以指定文件
public class TempFileConfig {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
