package com.oppo.open.config;

import com.oppo.open.aop.LogAspect;
import com.oppo.open.properties.HelloServiceProperties;
import com.oppo.open.service.DemoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnProperty(
        prefix = "com.wisdom",
        name = "isopen",
        havingValue = "true"
)
public class DemoConfig {

    private final HelloServiceProperties helloServiceProperties;

    public DemoConfig(HelloServiceProperties helloServiceProperties) {
        this.helloServiceProperties = helloServiceProperties;
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
    @Bean
    @ConditionalOnMissingBean
    public DemoService helloService() {
               return new DemoService(this.helloServiceProperties.getPrefix(),this.helloServiceProperties.getSuffix());
      }
}