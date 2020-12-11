package textboard.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import textboard.Dto.Member;
import textboard.Util.MysqlUtil;
import textboard.Util.SecSql;

public class MemberDao {

	public List<Member> getMembers() {
		List<Member> members = new ArrayList<>();

		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM `Member`");
		sql.append("ORDER BY memberNum ASC");

		List<Map<String, Object>> memberListMap = MysqlUtil.selectRows(sql);

		for (Map<String, Object> memberMap : memberListMap) {
			members.add(new Member(memberMap));
		}

		return members;
	}

	public Member getMember(int i) {
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM `Member`");
		sql.append("WHERE memberNum = ?", i);

		Map<String, Object> memberMap = MysqlUtil.selectRow(sql);

		Member member = new Member(memberMap);

		return member;
	}

	public int join(String name, String id, String password) {
		SecSql sql = new SecSql();

		sql.append("INSERT INTO Member");
		sql.append("Set regDate = NOW(),");
		sql.append("name = ?,", name);
		sql.append("id = ?,", id);
		sql.append("password = ?", password);

		return MysqlUtil.insert(sql);
	}

	public int memberidCehck(String id) {
		String[] idBytes = id.split("");

		List<Member> members = getMembers();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).id.equals(id)) {
				return -1;
			}
		}
		if (idBytes.length < 2) {
			return -3;
		}
		return 1;
	}

	public int memberPwCheck(String password) {
		String[] idBytes = password.split("");

		if (idBytes.length < 2) {
			return -2;
		}
		return 1;
	}

	public Member getMemberId(String id) {
		List<Member> members = getMembers();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).id.equals(id)) {
				return members.get(i);
			}
		}
		return null;
	}
}
