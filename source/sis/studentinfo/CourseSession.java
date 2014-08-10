package sis.studentinfo;
import java.util.*;

public class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	
	public CourseSession(String department, String number, Date startDate) {
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
	
	public void enroll(Student student) {
		students.add(student);
	}
	
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	
	public int getNumberOfStudents() {
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