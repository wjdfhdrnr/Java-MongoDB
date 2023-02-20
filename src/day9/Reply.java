package day9;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 답글번호(시퀀스 사용), 답글내용, 작성자, 등록일, 원본게시글정보
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Reply {
	private long replyNo = 0L;
	private String content = null;
	private String writer = null;
	private Date regdate = null;
	private Board board = null;
}
