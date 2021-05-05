package com.huade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilePathConfig implements WebMvcConfigurer {

    @Autowired
    private FilePathConfiguration filePathConfiguration;

//    private final String images = "/Users/develop/Desktop/online_exam/file/image/";
//    private final String mode = "/Users/develop/Desktop/Exam/file/mode/";
//    private final String file = "/Users/develop/Desktop/online_exam/file/";

//    private final String images = "/home/www/file/image/";
//    private final String mode = "/home/www/file/mode/";
//    private final String file = "/home/www/file/";
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+filePathConfiguration.getImages());
        registry.addResourceHandler("/modes/**").addResourceLocations("file:"+filePathConfiguration.getMode());
        registry.addResourceHandler("/files/**").addResourceLocations("file:"+filePathConfiguration.getFile());
    }
}
