package fr.fxjavadevblog.preconditions;

import java.util.regex.Pattern;

import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

import com.github.choonchernlim.betterPreconditions.core.Matcher;
import com.github.choonchernlim.betterPreconditions.core.PreconditionException;
import com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory;
import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherSolutionsPreconditionDemo
{

	private static Pattern pattern = Pattern.compile(PreconditionsMessages.REGEXP_MAJUSCULES);

	public static void executeOldSchoolJava(String name, Integer age, byte[] photo)
	{
		if (name == null)
		{
			throw new RuntimeException("le nom ne peut être nul");
		}

		if (!pattern.matcher(name).matches())
		{
			throw new RuntimeException("Le nom doit être écrit en majuscules");
		}

		if (age == null || (age <= 0 && age >= 150))
		{
			throw new RuntimeException("L'age doit être entre 0 et 150 ans");
		}

		if (photo == null)
		{
			throw new RuntimeException("Une photo doit être fournie");
		}

		if (!ValidationUtils.isPngData(photo))
		{
			throw new RuntimeException("La photo n'est pas au format PNG");
		}

		// log.info("Toutes les préconditions sont passées");
	}

	public static void executeApacheCommonsLang(String name, Integer age, byte[] photo)
	{
		Validate.notNull(name, PreconditionsMessages.MSG_NOT_NULL, "name");
		Validate.matchesPattern(name, PreconditionsMessages.REGEXP_MAJUSCULES, PreconditionsMessages.MSG_MAJUSCULES, "name");
		Validate.notNull(age, PreconditionsMessages.MSG_NOT_NULL, "age");
		Validate.inclusiveBetween(0, 150, age.intValue());
		Validate.notNull(photo, PreconditionsMessages.MSG_NOT_NULL, "photo");
		Validate.isTrue(ValidationUtils.isPngData(photo), PreconditionsMessages.MSG_IMAGE_PNG, "photo");

		// log.info("ApacheCommonsLang : toutes les préconditions sont
		// passées");
	}

	public static void executeSpringFramework(String name, Integer age, byte[] photo)
	{
		Assert.notNull(name, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "name"));
		Assert.notNull(age, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "age"));
		Assert.notNull(photo, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "photo"));
		Assert.isTrue(pattern.matcher(name).matches(), () -> String.format(PreconditionsMessages.MSG_MAJUSCULES, "name"));
		Assert.isTrue(age >= 0 && age <= 150, () -> String.format(PreconditionsMessages.MSG_AGE_ENTRE, "age", 0, 150));
		Assert.isTrue(ValidationUtils.isPngData(photo), () -> String.format(PreconditionsMessages.MSG_IMAGE_PNG, "photo"));
	}

	public static void executeGuava(String name, Integer age, byte[] photo)
	{
		Preconditions.checkNotNull(name, PreconditionsMessages.MSG_NOT_NULL, "name");
		Preconditions.checkNotNull(age, PreconditionsMessages.MSG_NOT_NULL, "age");
		Preconditions.checkNotNull(photo, PreconditionsMessages.MSG_NOT_NULL, "photo");
		Preconditions.checkArgument(pattern.matcher(name).matches(), PreconditionsMessages.REGEXP_MAJUSCULES, PreconditionsMessages.MSG_MAJUSCULES, "name");
		Preconditions.checkArgument(age >= 0 && age <= 150, PreconditionsMessages.MSG_AGE_ENTRE, "age", 0, 150);
		Preconditions.checkArgument(ValidationUtils.isPngData(photo), PreconditionsMessages.MSG_IMAGE_PNG, "photo");
	}
	

	public static void executeBetterPreconditions(String name, Integer age, byte[] photo)
	{
		PreconditionFactory.expect(name).not().toBeNull().check();
		PreconditionFactory.expect(age).not().toBeNull()
											 .toBeEqualOrGreaterThan(0)
											 .toBeEqualOrLessThan(150)
											 .check();
		PreconditionFactory.expect(photo).not().toBeNull().check();
		
		// TODO : créer des custom matcher pour les actions plus "particulières".
		
									
	}
}
