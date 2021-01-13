package textboard.Dto;

import java.util.Map;

public class Article {
	public int num;
	public int memberNum;
	public int views;
	public int boardNum;
	public int commentsCount;
	public int likes;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;
	public String extra__writer;
	public String extra__boardName;
	public String extra__boardCode;
	
	public Article(Map<String, Object> articleMap) {
		this.boardNum = (int) articleMap.get("boardNum");
		this.num = (int) articleMap.get("Num");
		this.views = (int) articleMap.get("views");
		this.memberNum = (int) articleMap.get("memberNum");
		this.commentsCount = (int) articleMap.get("commentsCount");
		this.likes = (int) articleMap.get("likes");
		this.regDate = (String) articleMap.get("regDate");
		if (articleMap.containsKey("extra__writer")) {
			this.extra__writer = (String) articleMap.get("extra__writer");
		}
		if (articleMap.containsKey("extra__boardName")) {
			this.extra__boardName = (String) articleMap.get("extra__boardName");
		}
		if (articleMap.containsKey("extra__boardCode")) {
			this.extra__boardCode = (String) articleMap.get("extra__boardCode");
		}
		this.updateDate = (String) articleMap.get("updateDate");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");
	}
}
