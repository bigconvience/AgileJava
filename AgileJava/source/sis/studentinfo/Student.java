package sis.studentinfo;

import java.util.*;

public class Student {
	public enum Grade {
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);

		private int points;

		Grade(int points) {
			this.points = points;
		}

		int getPoints() {
			return points;
		}
	}

	private String name;
	private int credits;
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String state = "";
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy =	new BasicGradingStrategy();

	public Student(final String name) {
		this.name = name;
		credits = 0;
	}

	public String getName() {
		return this.name;
	}

	int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	void setState(String state) {
		this.state = state.toUpperCase();
	}

	boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

	 void addGrade(Grade grade) {
      grades.add(grade);
   }

   double getGpa() {
      if (grades.isEmpty())
         return 0.0;
      double total = 0.0;
      for (Grade grade: grades)
         total += gradingStrategy.getGradePointsFor(grade);
      return total / grades.size();
   }

	int gradePointsFor(Grade grade) {
		if (grade == Grade.A) return 4;
		if (grade == Grade.B) return 3;
		if (grade == Grade.C) return 2;
		if (grade == Grade.D) return 1;
		return 0;
	}

	void setGradingStrategy(GradingStrategy gradingStrategy) {
	  this.gradingStrategy = gradingStrategy;
	}
}
