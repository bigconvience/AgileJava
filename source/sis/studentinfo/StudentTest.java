package sis.studentinfo;

public class StudentTest extends junit.framework.TestCase{
	final String firstStudentName = "Jane Doe";
	final Student firstStudent = new Student(firstStudentName);

	public void testCreate() {
		Student student = new Student(firstStudentName);
		String name = student.getName();
		assertEquals(firstStudentName, name);
	}

	public void testFullTime() {
		Student student = new Student("a");
		assertFalse(student.isFullTime());
	}

	public void testStudentStatus() {
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse(student.isFullTime());

		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}

	public void testInState() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
}
