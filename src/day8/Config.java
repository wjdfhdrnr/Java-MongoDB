package day8;

// 환경설정과 관련된 속성 정보를 보관하는 클래스 Properties
public class Config {
	
	// 서버접속정보
	public static final String URL = "mongodb://id218:pw218@1.234.5.158:37017/db218";
	
	// 사용할 수 있는 인원정보
	public static final int MAX = 10000;
	
	// 게시글의 숫자를 10개
	public static final int BOARDMAX = 10;
	
	// 데이터베이스 명칭
	public static final String DBNAME = "db218";
	
	// 답글 컬렉션 명칭(테이블)
	public static final String REPELYCOL = "replies";
	public static final String BOARDCOL = "boards";
	public static final String MEMBERCOL = "members";
	public static final String ADDRESSCOL = "addresses";
	public static final String TITANICCOL = "titanic";
	public static final String ITEMICCOL = "items";
	
	
	// 시퀀스용 컬렉션 명칭(테이블)
	public static final String RESEQUENCECOL = "sequence";	
	
	// 채팅용 서버정보
	public static final String BROKER = "tcp://1.234.5.158:11883";
	public static final String CONNECTID = "ds606";
	public static final String CONNECTPW = "ds606";
	
	
	
}
