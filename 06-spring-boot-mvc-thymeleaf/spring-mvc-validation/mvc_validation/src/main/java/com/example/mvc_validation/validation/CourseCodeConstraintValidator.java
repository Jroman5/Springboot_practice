package com.example.mvc_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
    private String coursePrefix;

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);    
        } else {
            return true;
        }
        
        // TODO Auto-generated method stub
        return result;
        // throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    @Override
    public void initialize(CourseCode courseCode){
        this.coursePrefix=courseCode.value();
        // ConstraintValidator.super.initialize(constraintAnnotation);
    }

    
    
}
