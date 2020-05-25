package fr.fxjavadevblog.demo;

import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_EMPTY_COLLECTION;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_NULL;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_RANGE_PATTERN;
import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_NOT_PNG_IMAGE;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MAX;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MIN;

import java.util.Collection;

import fr.fxjavadevblog.preconditions.Checker;

public class PreconditionDemo
{
	public static void execute(String name, Integer age, byte[] photo, Collection<String> competences)
	{
		Checker.notNull(name, MSG_NOT_NULL, "name");
		Checker.notNull(age, MSG_NOT_NULL, "age");
		Checker.notNull(photo, MSG_NOT_NULL, "photo");
		Checker.notNull(competences, MSG_NOT_NULL, "competences");
		Checker.respects(photo, ValidationUtils::isPngData, MSG_NOT_PNG_IMAGE);
		// Checker.inRange(age, AGE_MIN, AGE_MAX, MSG_RANGE_PATTERN, "age"); // manière classique
		Checker.inRange(age, AGE_MIN, AGE_MAX, AgeException::new, "age");  // avec désignation d'une exception
		Checker.notEmpty(competences, MSG_NOT_EMPTY_COLLECTION, "competences");

		// do the real job here ...
	}
}
