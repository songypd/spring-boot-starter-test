package com.demo.autoconfigure;

import com.demo.bean.Demo;
import com.demo.properties.DemoProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author syp
 * 2021-01-08
 */
@Configuration
@ConditionalOnClass
@ConditionalOnProperty(prefix = "demo.starter", value = "enable", matchIfMissing = true)
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Demo demo() {
        return new Demo();
    }
}

/**
 * ConditionalOnMissingBean
 * B仅当BeanFactory没有包含满足指定要求的bean时才匹配的Conditional 。 满足条件的任何条件都不必满足，并且同一bean不必满足这些条件。
 * 当放置在@Bean方法上时，bean类默认为工厂方法的返回类型：
 *
 * @Configuration public class MyAutoConfiguration {
 * @ConditionalOnMissingBean
 * @Bean public MyService myService() {
 * ...
 * }
 * <p>
 * }
 * 在上面的示例中，如果BeanFactory包含MyService类型的bean，则条件将匹配。
 * 该条件只能匹配到目前为止应用程序上下文已处理的bean定义，因此，强烈建议仅在自动配置类上使用此条件。 如果候选bean可能是由另一种自动配置创建的，请确保使用此条件的bean在之后运行。
 */
