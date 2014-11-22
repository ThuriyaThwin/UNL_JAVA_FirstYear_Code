package unl.cse.spring2014;

import java.util.ArrayList;

public class Course {

	private String courseDept;
	private String courseNumber;
	private ArrayList<Student> roster;
	public Course(String courseDept, String courseNumber) {
		super();
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.roster = new ArrayList<Student>();
	}
	
	public void addStudent(Student s) {
		this.roster.add(s);
	}

	@Override
	public String toString() {
		return "Course [courseDept=" + courseDept + ", courseNumber="
				+ courseNumber + ", roster=" + roster + "]";
	}
	
	
}
