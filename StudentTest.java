public class StudentTest extends junit.framework.TestCase{
	public void testCreate() {
		Student student = new Student("Jane Doe");
		String name = student.getName();
		assertEquals("Jane Doe", name);
	}
}