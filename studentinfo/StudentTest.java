package studentinfo;

public class StudentTest extends junit.framework.TestCase{
	final String firstStudentName = "Jane Doe";
	final Student firstStudent = new Student(firstStudentName);
	
	public void testCreate() {
		Student student = new Student(firstStudentName);
		String name = student.getName();
		assertEquals(firstStudentName, name);
	}
}