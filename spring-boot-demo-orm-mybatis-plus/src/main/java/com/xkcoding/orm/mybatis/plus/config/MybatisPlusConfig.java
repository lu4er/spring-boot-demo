package com.xkcoding.orm.mybatis.plus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * <p>
 * mybatis-plus 配置
 * </p>
 *
 * @package: com.xkcoding.orm.mybatis.plus.config
 * @description: mybatis-plus 配置
 * @author: yangkai.shen
 * @date: Created in 2018/11/8 17:29
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@MapperScan(basePackages = {"com.xkcoding.orm.mybatis.plus.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 性能分析拦截器，不建议生产使用
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 写入日志文件
        performanceInterceptor.setWriteInLog(true);
        // sql格式化
        performanceInterceptor.setFormat(true);
        // sql执行超时时长 毫秒
//        performanceInterceptor.setMaxTime(1L);
        // 属性 可配置format、maxTime
//        Properties properties = new Properties();
//        properties.setProperty("format", "true");
//        properties.setProperty("maxTime", "5");
//        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
