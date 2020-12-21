package textboard.Dto;

import java.util.Map;

public class Article {
	public int num;
	public int memberNum;
	public int views;
	public int boardNum;
	public int replyNum;
	public int recommadNum;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;
	public String extra__writer;
	public String extra__board;

	public Article(Map<String, Object> articleMap) {
		this.boardNum = (int) articleMap.get("boardNum");
		this.num = (int) articleMap.get("num");
		this.views = (int) articleMap.get("views");
		this.memberNum = (int) articleMap.get("memberNum");
		this.replyNum = (int) articleMap.get("replyNum");
		this.recommadNum = (int) articleMap.get("recommandNum");
		this.regDate = (String) articleMap.get("regDate");
		if (articleMap.containsKey("extra__writer")) {
			this.extra__writer = (String) articleMap.get("extra__writer");
		}
		if (articleMap.containsKey("extra__board")) {
			this.extra__board = (String) articleMap.get("extra__board");
		}
		this.updateDate = (String) articleMap.get("updateDate");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
	}
}
