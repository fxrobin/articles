package fr.fxjavadevblog.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * permet de déclencher une validation via BeanValidation.
 * 
 * @author robin
 *
 */
public class BeanValidationChecker
{
	// instanciation en EAGER d'un validator BeanValidation.
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * lance une validation sur l'objet data, potentiellement annoté avec des
	 * contraintes BeanValidation.
	 * 
	 * Les contraintes violées sont aggrégée aux sein d'une et une seule
	 * "IllegalArgumentException".
	 * 
	 * @param data
	 *            instance à tester.
	 */
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
