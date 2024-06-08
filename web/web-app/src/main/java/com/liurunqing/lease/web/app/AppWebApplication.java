package com.liurunqing.lease.web.app;

import com.liurunqing.lease.common.config.minio.MinioConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.liurunqing.lease.web.app.mapper")
@SpringBootApplication(exclude = MinioConfiguration.class)
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }
}
