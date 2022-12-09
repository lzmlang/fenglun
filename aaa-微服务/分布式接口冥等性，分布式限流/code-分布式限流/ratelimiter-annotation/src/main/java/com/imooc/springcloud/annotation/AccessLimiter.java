package com.imooc.springcloud.annotation;

/**
 * Created by 半仙.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimiter {

    int limit();

    String methodKey() default "";

}
