package textboard.Dto;

import java.util.Map;

public class Reply {
	public int replyNum;
	public int articleNum;
	public String name;
	public String regDate;
	public String updateDate;
	public String body;

	public Reply(Map<String, Object> replyMap) {
		this.replyNum = (int) replyMap.get("replyNum");
		this.articleNum = (int) replyMap.get("articleNum");
		this.name = (String) replyMap.get("name");
		this.regDate = (String) replyMap.get("regDate");
		this.updateDate = (String) replyMap.get("updateDate");
		this.body = (String) replyMap.get("body");
	}

}
