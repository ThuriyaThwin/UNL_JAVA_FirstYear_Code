package unl.cse.spring2014;

import java.util.ArrayList;

public class Student {

	private String nuid;
	private String firstName;
	private String lastName;
	private ArrayList<Course> schedule;
	
	/**
	 * Copy constructor:
	 */
	public Student(Student s) {
		this.nuid = s.nuid;
		this.firstName = s.firstName;
		this.lastName = s.lastName;
		this.schedule = new ArrayList<Course>(s.schedule);
	}
	
	public Student(String nuid, String firstName, String lastName) {
		super();
		this.nuid = nuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.schedule = new ArrayList<Course>();
	}
	
	public void addCourse(Course c) {
		this.schedule.add(c);
	}

	@Override
	public String toString() {
		return "Student [nuid=" + nuid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", schedule="  + "]";
	}
	
	
	
	
}
