package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jiangbenpeng on 3/3/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface MyAnnotation {

    String   value() default "";

    String   name();
    int      age();
    String[] newNames();

}

