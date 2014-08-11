package sis.studentinfo;
import java.util.*;

public class CourseSession implements Comparable<CourseSession> {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private static int count;
	private int numberOfCredits;

	private CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
		CourseSession.incrementCount();
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public static void incrementCount() {
		count += 1;
	}

	static void resetCount() {
		count = 0;
	}

	static int getCount() {
		return count;
	}

	public static CourseSession create(
				String department,
				String number,
				Date date) {
		return new CourseSession(department, number, date);
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

	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public int compareTo(CourseSession that) {
		return this.getDepartment().compareTo(that.getDepartment());
	}
}
