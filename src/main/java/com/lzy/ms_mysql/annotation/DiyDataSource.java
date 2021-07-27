package com.lzy.ms_mysql.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface DiyDataSource {
    String value();
}
