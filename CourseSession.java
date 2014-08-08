class CourseSession {
	private String department;
	private String number;
	private int numberOfStudents = 0;
	
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
		numberOfStudents = numberOfStudents + 1;
	}
	
	int getNumberOfStudents() {
		return numberOfStudents;
	}
}