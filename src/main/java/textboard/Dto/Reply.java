package textboard.Dto;

import java.util.Map;

import lombok.Data;

@Data
public class Reply {
	private int replyNum;
	private int articleNum;
	private String name;
	private String regDate;
	private String updateDate;
	private String body;

	public Reply(Map<String, Object> replyMap) {
		this.replyNum = (int) replyMap.get("replyNum");
		this.articleNum = (int) replyMap.get("articleNum");
		this.name = (String) replyMap.get("name");
		this.regDate = (String) replyMap.get("regDate");
		this.updateDate = (String) replyMap.get("updateDate");
		this.body = (String) replyMap.get("body");
	}

}
