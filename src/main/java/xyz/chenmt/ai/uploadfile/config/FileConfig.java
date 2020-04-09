package xyz.chenmt.ai.uploadfile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @program byh-service-patient
 * @description:
 * @author: chenmet
 * @create: 2019/03/06 11:24
 */
@Configuration
public class FileConfig {


    /**
     * 配置文件上传注解
     * @return
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //大小为5G  单位为bytes
        multipartResolver.setMaxUploadSize(5368709120L);
        multipartResolver.setMaxInMemorySize(2147483647);
        multipartResolver.setDefaultEncoding("UTF-8");

        return multipartResolver;
    }

}
