package com.saul.boot.business.aspect;

/**
 * <br/> @PackageName：com.fff.xianliu.annotation
 * <br/> @ClassName：Limit
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/20 19:33
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Parameter {
}