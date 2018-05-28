package fr.fxjavadevblog.others;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

import com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory;
import com.google.common.base.Preconditions;

import fr.fxjavadevblog.demo.BeanValidationChecker;
import fr.fxjavadevblog.demo.PngData;
import fr.fxjavadevblog.demo.ValidationUtils;
import fr.fxjavadevblog.preconditions.Checker;
import fr.fxjavadevblog.resources.PreconditionsMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class OtherSolutionsPreconditionDemo
{

	private static Pattern pattern = Pattern.compile(PreconditionsMessages.REGEXP_MAJUSCULES);

	@Getter
	@AllArgsConstructor
	protected static class InputData
	{
		@NotNull
		@NotEmpty
		@javax.validation.constraints.Pattern(regexp = PreconditionsMessages.REGEXP_MAJUSCULES)
		private String name;

		@NotNull
		@Min(0)
		@Max(150)
		private Integer age;

		@NotNull
		@PngData
		private byte[] photo;
	}

	public static void executeOldSchoolJava(String name, Integer age, byte[] photo, Collection<String> competences)
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

		if (competences == null || competences.isEmpty())
		{
			throw new RuntimeException("Les compétences ne peuvent pas être vides");
		}

		// log.info("Toutes les préconditions sont passées");
	}

	public static void executeApacheCommonsLang(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Validate.notNull(name, PreconditionsMessages.MSG_NOT_NULL, "name");
		Validate.matchesPattern(name, PreconditionsMessages.REGEXP_MAJUSCULES, PreconditionsMessages.MSG_MAJUSCULES, "name");
		Validate.notNull(age, PreconditionsMessages.MSG_NOT_NULL, "age");
		Validate.inclusiveBetween(0, 150, age.intValue());
		Validate.notNull(photo, PreconditionsMessages.MSG_NOT_NULL, "photo");
		Validate.isTrue(ValidationUtils.isPngData(photo), PreconditionsMessages.MSG_IMAGE_PNG, "photo");
		Validate.notNull(competences, PreconditionsMessages.MSG_NOT_NULL, "competences");
		Validate.notEmpty(competences);

		// log.info("ApacheCommonsLang : toutes les préconditions sont
		// passées");
	}

	public static void executeSpringFramework(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Assert.notNull(name, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "name"));
		Assert.notNull(age, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "age"));
		Assert.notNull(photo, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "photo"));
		Assert.notNull(competences, () -> String.format(PreconditionsMessages.MSG_NOT_NULL, "competences"));
		Assert.isTrue(pattern.matcher(name).matches(), () -> String.format(PreconditionsMessages.MSG_MAJUSCULES, "name"));
		Assert.isTrue(age >= 0 && age <= 150, () -> String.format(PreconditionsMessages.MSG_AGE_ENTRE, "age", 0, 150));
		Assert.isTrue(ValidationUtils.isPngData(photo), () -> String.format(PreconditionsMessages.MSG_IMAGE_PNG, "photo"));
		Assert.notEmpty(competences, "Les compétences ne peuvent pas être vides");

	}

	public static void executeGuava(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Preconditions.checkNotNull(name, PreconditionsMessages.MSG_NOT_NULL, "name");
		Preconditions.checkNotNull(age, PreconditionsMessages.MSG_NOT_NULL, "age");
		Preconditions.checkNotNull(photo, PreconditionsMessages.MSG_NOT_NULL, "photo");
		Preconditions.checkArgument(pattern.matcher(name).matches(), PreconditionsMessages.REGEXP_MAJUSCULES, PreconditionsMessages.MSG_MAJUSCULES, "name");
		Preconditions.checkArgument(age >= 0 && age <= 150, PreconditionsMessages.MSG_AGE_ENTRE, "age", 0, 150);
		Preconditions.checkArgument(ValidationUtils.isPngData(photo), PreconditionsMessages.MSG_IMAGE_PNG, "photo");
		Preconditions.checkNotNull(competences, PreconditionsMessages.MSG_NOT_NULL, "competences");
		Preconditions.checkArgument(competences.size() > 0, "Les compétences ne peuvent pas être vides");
	}

	public static void executeBetterPreconditions(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		PreconditionFactory.expect(name).not().toBeNull().check();
		PreconditionFactory.expect(age).not().toBeNull().toBeEqualOrGreaterThan(0).toBeEqualOrLessThan(150).check();
		PreconditionFactory.expect(photo).not().toBeNull().check();

		// TODO : créer des custom matcher pour les actions plus
		// "particulières".
	}

	public static void executeHomeMadePreconditions(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Checker.notNull(name, PreconditionsMessages.MSG_NOT_NULL, "name");
		Checker.notNull(age, PreconditionsMessages.MSG_NOT_NULL, "age");
		Checker.notNull(photo, PreconditionsMessages.MSG_NOT_NULL, "photo");
		Checker.respects(name, pattern, PreconditionsMessages.MSG_MAJUSCULES, "name");
		Checker.inRange(age, 0, 150, PreconditionsMessages.MSG_AGE_ENTRE, "age");
		Checker.respects(photo, ValidationUtils::isPngData, PreconditionsMessages.MSG_IMAGE_PNG, "photo");
		Checker.notEmpty(competences, "Les compétences de peuvent pas être vides");
	}

	public static void executeBeanValidation(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		InputData input = new InputData(name, age, photo);
		BeanValidationChecker.check(input);
	}
}
