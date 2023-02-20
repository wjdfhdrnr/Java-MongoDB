package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
	
	private int no = 0; // 학번
	private String name = null; // 이름
	private int grade = 1; // 학년
	private Date date = null;
	
	// 생성자
	public Student() {
		super();
	}
	
	// 생성자
	public Student(int no, String name, int grade, Date date) {
		super();
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.date = date;
	}
	
	// 학년을 1씩 증가시키기(4학년까지만)
	public void plusGrade() {
		this.grade++;
		if(this.grade > 4) { //4보다 크면
			this.grade = 4; // 4로 만들기
		}
	}
	
	
	
	
	
	
}
