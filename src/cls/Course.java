package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Course {
	private long code = 10000L; // 과목코드
	private String name = null; // 과목명
	private int credit = 0; // 학점
	private Date date = null; // DB에 자료가 저장되는 시점 기록
	private Professor professor = null; // 교수
	
	
	public Course() {
		super();
	}
	public Course(long code, String name, int credit, Date date, Professor professor) {
		super();
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.date = date;
		this.professor = professor;
	}
	
	
	
}
