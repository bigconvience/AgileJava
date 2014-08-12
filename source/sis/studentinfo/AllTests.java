package sis.studentinfo;

public class AllTests {
   public static junit.framework.TestSuite suite() {
      junit.framework.TestSuite suite =
         new junit.framework.TestSuite();
      suite.addTestSuite(StudentTest.class);
      suite.addTestSuite(CourseSessionTest.class);
      suite.addTestSuite(DateUtilTest.class);
      suite.addTestSuite(BasicGradingStrategyTest.class);
      suite.addTestSuite(HonorsGradingStrategyTest.class);
      return suite;
   }
}
