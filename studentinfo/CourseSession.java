package studentinfo;
import java.util.*;

/**
* Provides a representation of a single-semester
* session of a specific university course.
* @author Administrator
*/
class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	
	CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
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
	
	Student get(int index) {
		return students.get(index);
	}
	
	Date getStartDate() {
		return startDate;
	}
	
	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfdats = 16 * 7 -3;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfdats);
		return calendar.getTime();
	}
}