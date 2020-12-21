package textboard.Dto;

import java.util.Map;

public class Board {
	public int boardNum;
	public String name;
	public String regDate;
	public String uddateDate;
	public String code;
	
	public Board(int boardNum, String name) {
		this.boardNum = boardNum;
		this.name = name;
	}

	public Board(Map<String, Object> boardMap) {
		this.boardNum = (int) boardMap.get("boardNum");
		this.name = (String) boardMap.get("name");
		this.regDate = (String) boardMap.get("regDate");
		this.uddateDate = (String) boardMap.get("uddateDate");
		this.code = (String) boardMap.get("code");
	}
}
