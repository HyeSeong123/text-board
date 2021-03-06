package textboard.Dto;

import java.util.Map;

import lombok.Data;

@Data
public class Member {
	private int memberNum;
	private String regDate;
	private String name;
	private String id;
	private String password;

	public Member(int memberNum, String regDate, String name, String id, String password) {
		this.memberNum = memberNum;
		this.regDate = regDate;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public Member(Map<String, Object> memberMap) {
		this.memberNum = (int) memberMap.get("memberNum");
		this.regDate = (String) memberMap.get("regDate");
		this.name = (String) memberMap.get("name");
		this.id = (String) memberMap.get("id");
		this.password = (String) memberMap.get("password");
	}

}
