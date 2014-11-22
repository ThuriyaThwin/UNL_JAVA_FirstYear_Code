package unl.cse.spring2014;

public class Demo {

	public static void main(String args[]) {
		
		Student s = new Student("12345678", "Joe", "Kerr");
		Student t = new Student(s);
		
		Course c1 = new Course("CSCE", "156");
		Course c2 = new Course("MATH", "208");
		
		System.out.println(s);
		System.out.println(t);
		
		s.addCourse(c1);
		s.addCourse(c2);
		c1.addStudent(s);
		c2.addStudent(s);

		System.out.println(s);
		System.out.println(t);
		
	}
}
