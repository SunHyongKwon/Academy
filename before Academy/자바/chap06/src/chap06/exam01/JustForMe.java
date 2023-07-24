
package chap06.exam01;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JustForMe {
	String value() default "just";
	int num() default 4;
	String me() default "me";
}

