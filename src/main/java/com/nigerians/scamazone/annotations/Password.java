package com.nigerians.scamazone.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE })
public @interface Password {
    String message() default "Password must be between 8 and 32 characters, and contain at least one digit, one lowercase letter, one uppercase letter, and one special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
