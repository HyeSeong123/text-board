package textboard.Dto;

import java.util.Map;

import lombok.Data;

@Data
public class Recommand {

	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int articleId;

	public Recommand(Map<String, Object> recommand) {
		this.id = (int) recommand.get("id");
		this.regDate = (String) recommand.get("regDate");
		this.updateDate = (String) recommand.get("updateDate");
		this.memberId = (int) recommand.get("memberId");
		this.articleId = (int) recommand.get("articleId");
	}
}
