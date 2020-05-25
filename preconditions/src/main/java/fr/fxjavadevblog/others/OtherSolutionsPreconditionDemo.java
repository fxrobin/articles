package fr.fxjavadevblog.others;


import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_EMPTY_COLLECTION;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_NULL;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_PNG_IMAGE;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_RANGE_PATTERN;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_UPPER_CASE;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MAX;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MIN;
import static fr.fxjavadevblog.resources.PreconditionsRules.REGEXP_MAJUSCULES;

import java.util.Collection;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

import com.github.choonchernlim.betterPreconditions.core.Matcher;
import com.github.choonchernlim.betterPreconditions.core.PreconditionException;
import com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory;
import com.google.common.base.Preconditions;

import fr.fxjavadevblog.demo.AgeException;
import fr.fxjavadevblog.demo.BeanValidationChecker;
import fr.fxjavadevblog.demo.PngData;
import fr.fxjavadevblog.demo.ValidationUtils;
import fr.fxjavadevblog.preconditions.Checker;
import lombok.AllArgsConstructor;
import lombok.Getter;



public class OtherSolutionsPreconditionDemo
{

	private static java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(REGEXP_MAJUSCULES);

	@Getter
	@AllArgsConstructor
	protected static class InputData
	{
		@NotNull
		@NotEmpty
		@Pattern(regexp = REGEXP_MAJUSCULES)
		private String name;

		@NotNull
		@Min(AGE_MIN)
		@Max(AGE_MAX)
		private Integer age;

		@NotNull
		@PngData
		private byte[] photo;
		
		@NotNull
		@NotEmpty
		private Collection<String> competences;
	}

	public static void executeOldSchoolJava(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		if (name == null)
		{
			throw new IllegalArgumentException(String.format(MSG_NOT_NULL, "name"));
		}

		if (!pattern.matcher(name).matches())
		{
			throw new IllegalArgumentException(String.format(MSG_UPPER_CASE, "name"));
		}

		if (age == null)
		{
			throw new IllegalArgumentException(String.format(MSG_NOT_NULL, "age"));
		}
			
		if (age <= AGE_MIN && age >= AGE_MAX)
		{
			throw new IllegalArgumentException(String.format(MSG_RANGE_PATTERN, "age", age, AGE_MIN, AGE_MAX));
		}

		if (photo == null)
		{
			throw new IllegalArgumentException(String.format(MSG_NOT_NULL, "photo"));
		}

		if (!ValidationUtils.isPngData(photo))
		{
			throw new IllegalArgumentException(String.format(MSG_NOT_PNG_IMAGE, "photo"));
		}

		if (competences == null || competences.isEmpty())
		{
			throw new IllegalArgumentException(String.format(MSG_NOT_EMPTY_COLLECTION, "competences"));
		}

		// log.info("Toutes les préconditions sont passées");
	}

	public static void executeApacheCommonsLang(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Validate.notNull(name, MSG_NOT_NULL, "name");
		Validate.matchesPattern(name, REGEXP_MAJUSCULES, MSG_UPPER_CASE, "name");
		Validate.notNull(age, MSG_NOT_NULL, "age");
		Validate.inclusiveBetween(AGE_MIN, AGE_MAX, age.intValue());
		Validate.notNull(photo, MSG_NOT_NULL, "photo");
		Validate.isTrue(ValidationUtils.isPngData(photo), MSG_NOT_PNG_IMAGE, "photo");
		Validate.notNull(competences, MSG_NOT_NULL, "competences");
		Validate.notEmpty(competences);

		// log.info("ApacheCommonsLang : toutes les préconditions sont vérfiées");
	}

	public static void executeSpringFramework(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Assert.notNull(name, () -> String.format(MSG_NOT_NULL, "name"));
		Assert.notNull(age, () -> String.format(MSG_NOT_NULL, "age"));
		Assert.notNull(photo, () -> String.format(MSG_NOT_NULL, "photo"));
		Assert.notNull(competences, () -> String.format(MSG_NOT_NULL, "competences"));
		Assert.isTrue(pattern.matcher(name).matches(), () -> String.format(MSG_UPPER_CASE, "name"));
		Assert.isTrue(age >= AGE_MIN && age <= AGE_MAX, () -> String.format(MSG_RANGE_PATTERN, "age", age, AGE_MIN, AGE_MAX));
		Assert.isTrue(ValidationUtils.isPngData(photo), () -> String.format(MSG_NOT_PNG_IMAGE, "photo"));
		Assert.notEmpty(competences, () -> String.format(MSG_NOT_EMPTY_COLLECTION, "competences"));
	}

	public static void executeGuava(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Preconditions.checkNotNull(name, MSG_NOT_NULL, "name");
		Preconditions.checkNotNull(age, MSG_NOT_NULL, "age");
		Preconditions.checkNotNull(photo, MSG_NOT_NULL, "photo");
		Preconditions.checkArgument(pattern.matcher(name).matches(), REGEXP_MAJUSCULES, MSG_UPPER_CASE, "name");
		Preconditions.checkArgument(age >= AGE_MIN && age <= AGE_MAX, MSG_RANGE_PATTERN, "age", age, AGE_MIN, AGE_MAX);
		Preconditions.checkArgument(ValidationUtils.isPngData(photo), MSG_NOT_PNG_IMAGE, "photo");
		Preconditions.checkNotNull(competences, MSG_NOT_NULL, "competences");
		Preconditions.checkArgument(competences.size() > 0, MSG_NOT_EMPTY_COLLECTION, "competences");
	}

	public static void executeBetterPreconditions(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		PreconditionFactory.expect(name).not().toBeNull().check();
		PreconditionFactory.expect(age).not().toBeNull().toBeEqualOrGreaterThan(AGE_MIN).toBeEqualOrLessThan(AGE_MAX).check();
		PreconditionFactory.expect(photo).not().toBeNull().check();
		PreconditionFactory.expect(competences).not().toBeEmpty();
		// TODO : créer des custom matcher pour les actions plus "particulières".
	}

	public static void executeHomeMadePreconditions(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Checker.notNull(name, MSG_NOT_NULL, "name");
		Checker.notNull(age, MSG_NOT_NULL, "age");
		Checker.notNull(photo, MSG_NOT_NULL, "photo");
		Checker.respects(name, pattern, MSG_UPPER_CASE, "name");
		Checker.inRange(age, AGE_MIN, AGE_MAX, AgeException::new, "age");
		Checker.respects(photo, ValidationUtils::isPngData, MSG_NOT_PNG_IMAGE, "photo");
		Checker.notEmpty(competences, MSG_NOT_EMPTY_COLLECTION, "competences");
	}

	public static void executeBeanValidation(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		InputData input = new InputData(name, age, photo, competences);
		BeanValidationChecker.check(input);
	}
}
