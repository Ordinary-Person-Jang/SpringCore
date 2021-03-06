package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {

}
