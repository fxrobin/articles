package fr.fxjavadevblog.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * validator Bean Validation spécialisé dans la validation de données PNG
 * contenues dans un tableau d'octets.
 * 
 * @author fxjavadevblog
 *
 */
public class PngDataValidator implements ConstraintValidator<PngData, Object>
{
	@Override
	public boolean isValid(Object data, ConstraintValidatorContext context)
	{
		return ValidationUtils.isPngData(data);	
	}
}
