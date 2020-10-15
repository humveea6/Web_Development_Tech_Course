package com.webdevelope.summoned.task.configs;

import java.util.List;

import com.webdevelope.summoned.task.interceptors.SeniorPerimissionRequiredInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SeniorPerimissionRequiredInteceptor()).addPathPatterns("/**");
    }

//    /**
//     * 路径匹配配置
//     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer
//                // 是否开启后缀模式匹配，如 '/user' 是否匹配 '/user.*'，默认 true
//                .setUseSuffixPatternMatch(false)
//                // 是否开启后缀路径模式匹配，如 '/user' 是否匹配 '/user/'，默认 true
//                .setUseTrailingSlashMatch(true);
//    }
//
//    /**
//     * 将对于静态资源的请求转发到 Servlet 容器的默认处理静态资源的 Servlet
//     * 因为将 Spring 的拦截模式设置为 "/" 时会对静态资源进行拦截
//     */
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new VisitorAnnotationResolver());
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
//        registry.addViewController("/download").setViewName("forward:/download.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
//    }

//    @Bean
//    @Lazy
//    public HikariDataSource ds() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("ru.yandex.clickhouse.ClickHouseDriver");
//        config.setJdbcUrl("jdbc:clickhouse://proxy.clickhouse.internal:18081/npapp?user=default");
//        config.setMinimumIdle(10);
//        //池中最大链接数量
//        config.setMaximumPoolSize(20);
//        return new HikariDataSource(config);
//    }
}
