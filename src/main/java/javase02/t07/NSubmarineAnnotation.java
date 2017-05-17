package javase02.t07;

import java.lang.annotation.*;

/**
 * Created by rusamaha on 5/16/17.
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NSubmarineAnnotation {
    String nameOfAuthor();
    String typeOfSubmarine() default "Educational";
}
