package health.trayt.automation.annotations;

import java.lang.annotation.*;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchWindowTo {
    String value() default "";
}
