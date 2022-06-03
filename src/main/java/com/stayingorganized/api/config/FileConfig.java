package com.stayingorganized.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("dev")
@PropertySource("classpath:file-storage-dev.properties")
public class FileConfig implements WebMvcConfigurer {

    @Value("${file.storage.location}")
    private String fileStorageLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/folder/**")
                .addResourceLocations("file:" + fileStorageLocation + "/");
    }
}
