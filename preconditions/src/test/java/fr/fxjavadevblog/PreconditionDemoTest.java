package fr.fxjavadevblog;

import java.util.Arrays;
import java.util.Collection;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runners.MethodSorters;

import fr.fxjavadevblog.demo.PreconditionDemo;
import fr.fxjavadevblog.others.OtherSolutionsPreconditionDemo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PreconditionDemoTest
{

	private static final int TEST_RUNS = 10000;

	private static byte[] fakePngImage = new byte[] { (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A, 0x10, 0x10 };

	private static Collection<String> competences = Arrays.asList("NINJA", "COMBAT RAPPROCHE", "TELECOM", "HACKING", "JUSTICE");

	@RepeatedTest(TEST_RUNS)
	void testNominalExecute()
	{
		PreconditionDemo.execute("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testApacheCommonsLang()
	{
		OtherSolutionsPreconditionDemo.executeApacheCommonsLang("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testOldSchoolJava()
	{
		OtherSolutionsPreconditionDemo.executeOldSchoolJava("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testHomeMadePreconditions()
	{
		OtherSolutionsPreconditionDemo.executeHomeMadePreconditions("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testBeanValidationPreconditions()
	{
		OtherSolutionsPreconditionDemo.executeBeanValidation("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testSpringFramework()
	{
		OtherSolutionsPreconditionDemo.executeSpringFramework("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testGuava()
	{
		OtherSolutionsPreconditionDemo.executeGuava("WAYNE", 35, fakePngImage, competences);
	}

	@RepeatedTest(TEST_RUNS)
	void testBetterPreconditions()
	{
		OtherSolutionsPreconditionDemo.executeBetterPreconditions("WAYNE", 35, fakePngImage, competences);
	}

}
