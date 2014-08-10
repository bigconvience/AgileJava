package sis.studentinfo;
import junit.framework.TestSuite;

public class AllTest {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}
}