package com.yundao.tenant.web.annotation;

import java.lang.annotation.*;

/**
 * 字段描述注解
 *
 * @author chenyuanjian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface FieldDescription {
    String value() default "";
}