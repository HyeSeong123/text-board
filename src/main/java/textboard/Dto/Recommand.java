package textboard.Dto;

import java.util.Map;

public class Recommand {

	public int id;
	public String regDate;
	public String updateDate;
	public int memberId;
	public int articleId;

	public Recommand(Map<String, Object> recommand) {
		this.id = (int) recommand.get("id");
		this.regDate = (String) recommand.get("regDate");
		this.updateDate = (String) recommand.get("updateDate");
		this.memberId = (int) recommand.get("memberId");
		this.articleId = (int) recommand.get("articleId");
	}
}
