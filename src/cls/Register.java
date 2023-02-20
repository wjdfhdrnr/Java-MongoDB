package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 수강신청

@Getter
@Setter
@ToString

public class Register {
	
	private int code = 0;
	private Course course = null; // 신청과목 // 교수정보는 Course 클래스에서 정의해놓음.
	private Student student = null; // 학생 
	private Date date = new Date();
	
	public Register() {
		super();
	}

	public Register(int code, Course course, Student student, Date date) {
		super();
		this.code = code;
		this.course = course;
		this.student = student;
		this.date = date;
	}	

}
