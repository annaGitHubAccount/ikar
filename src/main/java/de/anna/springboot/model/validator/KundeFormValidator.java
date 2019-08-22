package de.anna.springboot.model.validator;

import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class KundeFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return KundeForm.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        KundeForm kundeForm = (KundeForm) object;

        if (
                        !StringUtils.isEmpty(kundeForm.getLandVonPostanschrift()) ||
                        !StringUtils.isEmpty(kundeForm.getHausNrVonPostanschrift()) ||
                        !StringUtils.isEmpty(kundeForm.getOrtVonPostanschrift()) ||
                        !StringUtils.isEmpty(kundeForm.getStrasseVonPostanschrift())
        ) {

            ValidationUtils.rejectIfEmpty(errors, "landVonPostanschrift", "feld.isErfordelich");
            ValidationUtils.rejectIfEmpty(errors, "ortVonPostanschrift", "feld.isErfordelich");
            ValidationUtils.rejectIfEmpty(errors, "strasseVonPostanschrift", "feld.isErfordelich");
            ValidationUtils.rejectIfEmpty(errors, "hausNrVonPostanschrift", "feld.isErfordelich");
        }
    }
}
