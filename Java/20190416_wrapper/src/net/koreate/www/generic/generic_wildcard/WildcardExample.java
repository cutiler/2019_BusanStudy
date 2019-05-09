package net.koreate.www.generic.generic_wildcard;

import java.util.Arrays;

public class WildcardExample {
	
	public static void registerCourse(Course<?> course) {
		
		System.out.println(course.getName()+" 수강생");
		
		for(int i=0; i < course.getStudents().length; i++) {
			System.out.println(course.getStudents()[i]+" ");
		}
		
	}
	
	public static void registerStudentCourse(Course<? extends Student> course) {
		System.out.println(course.getName()+" 수강생");
		System.out.println(Arrays.toString(course.getStudents()));
		
	}
	
	public static void registerWorkerCourse(Course<? super Worker> course) {
		System.out.println(course.getName()+" 수강생");
		System.out.println(Arrays.toString(course.getStudents()));
	}
	
	
	public static void main(String[] args) {
		
		Course<Person> personCourse = new Course<>("일반인과정",5);
		
		personCourse.add(new Person("일반인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new HighStudent("고등학생"));
		personCourse.add(new Person("일반인2"));
		
		Course<Worker> workCourse = new Course<>("직장인과정",5);
		workCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<>("학생과정",5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("학생"));
		
		Course<Student> highStudentCourse = new Course<>("고등학생과정",5);
		highStudentCourse.add(new HighStudent("학생"));
		
		registerCourse(personCourse);
		registerCourse(workCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		
		System.out.println("=================================================");
		registerStudentCourse(studentCourse);
		registerStudentCourse(highStudentCourse);
		
		System.out.println("=================================================");
		registerWorkerCourse(workCourse);
		registerWorkerCourse(personCourse);
		registerWorkerCourse(new Course<Object>("전체교육과정",50));
		
		
		
	}

}
