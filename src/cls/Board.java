package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// getter,setter는 변수명 수정시 매번 재생성해야하는 불편있음
// lombok 라이브러리 => 편리성, 연결성
// 오라클 라이브러리임

@Getter
@Setter
@ToString

public class Board {
	
	private long brdNo=0L; // 글번호
	private String brdTitle=""; // 글제목
	private String brdContent=""; // 글내용
	private String brdWriter=""; // 작성자
	private long brdHit=0L; // 조회수
	private Date brdDate=null; // 등록일자
	
	
}
