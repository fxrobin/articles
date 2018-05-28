package fr.fxjavadevblog;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runners.MethodSorters;

import fr.fxjavadevblog.demo.PreconditionDemo;
import fr.fxjavadevblog.others.OtherSolutionsPreconditionDemo;


	
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PreconditionDemoTest
{
	
	private static final int TEST_RUNS = 10000;
	
	private static byte[] pngImage = new byte[] { (byte) 0x89,	0x50,	0x4E,	0x47, 0x0D, 0x0A, 0x1A, 0x0A , 0x10, 0x10};
	
	
	@RepeatedTest(TEST_RUNS)
	void testNominalExecute()
	{
		PreconditionDemo.execute("Robin", 42, LocalDate.of(1975, Month.JUNE, 16), Arrays.asList("XML", "JAVA", "JSF", "JPA"));
	}
	
	@RepeatedTest(TEST_RUNS)
	void testApacheCommonsLang()
	{
		OtherSolutionsPreconditionDemo.executeApacheCommonsLang("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testOldSchoolJava()
	{
		OtherSolutionsPreconditionDemo.executeOldSchoolJava("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testHomeMadePreconditions()
	{
		OtherSolutionsPreconditionDemo.executeHomeMadePreconditions("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testBeanValidationPreconditions()
	{
		OtherSolutionsPreconditionDemo.executeBeanValidation("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testSpringFramework()
	{
		OtherSolutionsPreconditionDemo.executeSpringFramework("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testGuava()
	{
		OtherSolutionsPreconditionDemo.executeGuava("ROBIN", 42, pngImage);
	}
	
	@RepeatedTest(TEST_RUNS)
	void testBetterPreconditions()
	{
		OtherSolutionsPreconditionDemo.executeBetterPreconditions("ROBIN", 42, pngImage);
	}
	


}
