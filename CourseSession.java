import java.util.ArrayList;

class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
	}
	
	String getDepartment() {
		return department;
	}
	
	String getNumber() {
		return number;
	}
	
	void enroll(Student student) {
		students.add(student);
	}
	
	int getNumberOfStudents() {
		return students.size();
	}
	
	java.util.ArrayList<Student> getAllStudents() {
		return students;
	}
}