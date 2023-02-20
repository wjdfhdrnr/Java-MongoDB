package main2;

import java.util.Date;

import cls.Course;
import cls.Professor;
import cls.Register;
import cls.Student;

public class Main4 {

	public static void main(String[] args) {
		
		// 1. 학생등록
		Student student = new Student(100, "a", 1, new Date());
		
		// 2. 교수등록
		Professor professor = new Professor(1, "b", "303호", new Date());
		
		// 3. 과목등록
		Course course = new Course(123L, "JAVA프로그래밍", 3, new Date(), professor);
		
		// 4. 수강신청(1개만)
		Register register = new Register(12, course, student, new Date());
		
		// 5. 수강신청 내역 출력(1개만)
		System.out.println(register.toString());
		

	}

}
