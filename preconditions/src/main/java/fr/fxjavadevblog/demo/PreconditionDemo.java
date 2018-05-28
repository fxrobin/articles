package fr.fxjavadevblog.demo;

import java.time.LocalDate;
import java.util.List;

import fr.fxjavadevblog.preconditions.Checker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PreconditionDemo
{
	
	private static final int AGE_MAX = 150;
	private static final int AGE_MIN = 0;
	private static final String MSG_RANGE_PATTERN = "l'argument %s doit être entre %d et %d inclus";
	private static final String MSG_NOT_NULL_PATTERN = "l'argument %s ne peut être nul";
	private static final String MSG_NOT_EMPTY_COLLECTION ="l'argument %s ne peut pas être une collection sans éléments";

	public static void execute(String name, Integer age, LocalDate dateNaissance, List<String> competences)
	{
		Checker.notNull(name, MSG_NOT_NULL_PATTERN, "name");
		Checker.notNull(age, MSG_NOT_NULL_PATTERN, "age");
		Checker.notNull(dateNaissance, MSG_NOT_NULL_PATTERN, "dateNaissance");
		Checker.notNull(competences, MSG_NOT_NULL_PATTERN, "competences");
		Checker.inRange(age, AGE_MIN , AGE_MAX, MSG_RANGE_PATTERN, "age");
		Checker.notEmpty(competences, MSG_NOT_EMPTY_COLLECTION, "competences");
		
		// log.info("Tous les arguments sont vérifiés");
	}

}
