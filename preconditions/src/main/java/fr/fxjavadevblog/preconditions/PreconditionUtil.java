package fr.fxjavadevblog.preconditions;

import java.util.Collection;

public final class PreconditionUtil
{

	public static void validateNotNull(Object arg, String format, Object... vals)
	{
		if (arg == null) { throw new IllegalArgumentException(String.format(format, vals)); }
	}

	public static void validateRange(Integer arg, int min, int max, String msgRangePattern, String vals)
	{
		if (arg == null || arg < min || arg > max) { throw new IllegalArgumentException(String.format(msgRangePattern, vals, min, max)); }
	}

	public static void validateNotEmpty(Collection<?> competences, String format, Object... vals)
	{
		if (competences == null || competences.isEmpty())
		{
			throw new IllegalArgumentException(String.format(format, vals));
		}
		
	}

}
