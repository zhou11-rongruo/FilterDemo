package com.example.filterdemo1.config;

import com.example.filterdemo1.filter.Filter2;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou11
 * @version 1.0.0
 * @description TODO
 * @date 2021/4/24
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new Filter2());
        bean.addUrlPatterns("/filter/2");
        return bean;
    }
}
