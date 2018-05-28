package fr.fxjavadevblog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.preconditions.Checker;

class PreconditionUtilTest
{
	@Test
	void testValidateNotNull()
	{
		try
		{
			Checker.notNull(null, "L'attribut %s ne peut pas être nul", "undefined");
		}
		catch (IllegalArgumentException e)
		{
			assertEquals("L'attribut undefined ne peut pas être nul", e.getMessage());
		}
	}

}
