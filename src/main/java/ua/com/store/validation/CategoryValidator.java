package ua.com.store.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.store.entity.Category;

@Component
public class CategoryValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Category.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category category = (Category) o;
        if (((Category) o).getCategoryOfProduct().isEmpty()){
            errors.rejectValue("categoryOfProduct","","field is Empty");
        }
    }
}
