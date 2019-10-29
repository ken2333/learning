package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
    public enum  sex{MAN,WOMAN}
    String name () default "default";
    int age() default 0;
    sex SEX() default sex.MAN;

}
