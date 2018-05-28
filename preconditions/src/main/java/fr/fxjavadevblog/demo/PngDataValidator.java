package fr.fxjavadevblog.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PngDataValidator implements ConstraintValidator<PngData, Object>
{
	
	

	@Override
	public boolean isValid(Object arg, ConstraintValidatorContext arg1)
	{
		if (arg instanceof byte[])
		{
			byte[] data = (byte[]) arg;
			return ValidationUtils.isPngData(data);
		}
		else
		{
			return false;
		}
	}

}
