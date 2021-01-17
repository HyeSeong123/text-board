package textboard.Dto;

import java.util.Map;

import lombok.Data;

@Data
public class Board {
	private int boardNum;
	private String name;
	private String regDate;
	private String uddateDate;
	private String code;
	
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
