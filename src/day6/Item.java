package day6;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private long code = 0L;
	private String name = null;
	private String content = null;
	private int price = 0;
	private int quantity = 0;
	private Date regdate = null;

}
