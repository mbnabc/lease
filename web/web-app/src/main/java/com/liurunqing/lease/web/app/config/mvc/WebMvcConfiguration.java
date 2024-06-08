package com.liurunqing.lease.web.app.config.mvc;

import com.liurunqing.lease.common.config.mvc.CodeEnumConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Value("${app.auth.path-patterns.include}")
    private String[] includePathPatterns;

    @Value("${app.auth.path-patterns.exclude}")
    private String[] excludePathPatterns;

    @Autowired
    private CodeEnumConverter codeEnumConverter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authInterceptor)
                .addPathPatterns(includePathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.codeEnumConverter);
    }
}
