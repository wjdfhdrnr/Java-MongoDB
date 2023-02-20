package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 등록된 교과목 목록을 저장하는 클래스

@Getter
@Setter
@ToString
public class CourseList {
	
	// 배열은 반드시 개수가 필요함.
	private Course[] courseArray = new Course[10];
	private int idx = 0; // 배열 내부의 개수를 저장하는 변수
	
	// 등록된 교과목의 교수정보 중에서 교수명과 교수방을 출력하는 메소드
	public void printProfessorNameAndRoom() {
		for(int i=0; i<idx; i++) {
			Professor professor = this.courseArray[i].getProfessor();
			System.out.println("교수명 :" + professor.getName() + "교수방 :" + professor.getRoom());
			
		}
	}
	
	
	// 등록된 교과목의 교수정보를 출력
	public void printProfessor() {
		for(int i=0; i <idx; i++) {
			Professor professor = this.courseArray[i].getProfessor();
			System.out.println(professor.toString());
		}
	}
	
	// 과목을 1개씩 등록할 수 있는 메소드(교수가 등록함)
	public void insertCourse(Course course) {
		// idx는 현재 추가된 개수 < 배열의 전체 개수
		if(this.idx < this.courseArray.length) {
			this.courseArray[idx]=course;
			this.idx++;
		}
		else {
			System.out.println("등록 불가");
		}
	}
	
	// 추가된 과목의 전체 내용 출력
	public void printCourse() {
		for(int i=0; i<idx; i++) {
			System.out.println(this.courseArray[i].toString());
		}
	}
	
	// 마지막에 추가한 과목 삭제하는 메소드
	public void deleteCourse() {
		if(this.idx > 0) {
			this.idx--;
		}
	}
	
	// 과목중에서 전달받는 학점에 해당하는 과목 조회(ex. 3을 전달하면 3학점에 해당하는 과목만)
	public void printCate(int cre) {
		for(int i = 0; i<this.idx; i++) {
			if(this.courseArray[i].getCredit() == cre) {
				System.out.println(courseArray[i].toString());
			}
		}
	}

}
