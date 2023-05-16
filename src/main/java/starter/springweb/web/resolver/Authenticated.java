package starter.springweb.web.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/16
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authenticated {
}
