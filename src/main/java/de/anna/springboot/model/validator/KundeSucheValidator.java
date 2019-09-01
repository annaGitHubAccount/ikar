package de.anna.springboot.model.validator;

import de.anna.springboot.model.form.KundeSucheForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KundeSucheValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return KundeSucheForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
