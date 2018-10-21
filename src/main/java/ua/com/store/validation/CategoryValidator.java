package ua.com.store.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.store.dao.CategoryDAO;
import ua.com.store.entity.Category;

@Component
public class CategoryValidator implements Validator {

    @Autowired
    private CategoryDAO dao;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Category.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category category = (Category) o;
        if (category.getCategoryOfProduct().isEmpty()){
            errors.rejectValue("categoryOfProduct","","field is Empty");
        }
        else if (dao.findByCategoryName(category.getCategoryOfProduct()) != null){
            errors.rejectValue("categoryOfProduct","","This category already exist");
        }
    }
}
