package day14;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private long no = 0L;
	private String title = "";
	private String content = "";
	private String writer = "";
	private long hit = 0L;
	private Date date = null;
	
}
