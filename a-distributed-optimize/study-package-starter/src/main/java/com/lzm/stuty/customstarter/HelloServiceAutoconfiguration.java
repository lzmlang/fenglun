package com.lzm.stuty.customstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luo_zm
 * @DESCRIPTION
 * @create 2020/8/27 15:56
 */
@Configuration
@ComponentScan({"com.lzm.stuty.customstarter"})
@ConditionalOnProperty(prefix = "study", name = "enable", havingValue = "true")
public class HelloServiceAutoconfiguration {
}
