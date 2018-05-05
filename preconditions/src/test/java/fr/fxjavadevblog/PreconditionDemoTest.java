package fr.fxjavadevblog;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.preconditions.PreconditionDemo;

class PreconditionDemoTest
{

	@Test
	void testNominalExecute()
	{
		PreconditionDemo.execute("Robin", 42, LocalDate.of(1975, Month.JUNE, 16), Arrays.asList("XML", "JAVA", "JSF", "JPA"));
	}

}
