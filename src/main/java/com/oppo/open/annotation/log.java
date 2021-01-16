package com.oppo.open.annotation;

import java.lang.annotation.*;

/**
 * @author admin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface log {

}