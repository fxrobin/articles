package fr.fxjavadevblog.demo;

import static fr.fxjavadevblog.resources.PreconditionsMessages.MSG_RANGE_PATTERN;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MAX;
import static fr.fxjavadevblog.resources.PreconditionsRules.AGE_MIN;


@SuppressWarnings("serial")
public class AgeException extends RuntimeException
{
	public AgeException(String argumentName, Integer argumentValue)
	{
		super(String.format(MSG_RANGE_PATTERN, argumentName , argumentValue, AGE_MIN, AGE_MAX));
	}
}
