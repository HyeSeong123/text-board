package textboard.Dto;

import java.util.Map;

public class Board {
	public int boardNum;
	public String name;

	public Board(int boardNum, String name) {
		this.boardNum = boardNum;
		this.name = name;
	}

	public Board(Map<String, Object> boardMap) {
		this.boardNum = (int) boardMap.get("boardNum");
		this.name = (String) boardMap.get("name");
	}
}
