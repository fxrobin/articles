package fr.fxjavadevblog.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class BeanValidationChecker
{
	private static Validator validator;
    
	static
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator =  factory.getValidator();
	}

	public static <T> void check(T data)
	{
		Set<ConstraintViolation<T>> violations = validator.validate(data);
		if (!violations.isEmpty())
		{
			StringBuilder sb = new StringBuilder();
			violations.forEach(v -> sb.append(v.getMessage()).append("\n"));
			throw new IllegalArgumentException(sb.toString());
		}		
	}

}
