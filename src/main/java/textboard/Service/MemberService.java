package textboard.Service;

import java.util.List;

import textboard.Container.Container;
import textboard.Dao.MemberDao;
import textboard.Dto.Member;

public class MemberService {

	MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public int join(String name, String id, String password) {
		return memberDao.join(name, id, password);
	}

	public int idCheck(String id) {
		return memberDao.memberidCehck(id);
	}

	public int pwCheck(String password) {
		return memberDao.memberPwCheck(password);
	}

	public List<Member> getMembers() {
		return memberDao.getMembers();
	}

	public Member getMemberId(String id) {
		return memberDao.getMemberId(id);
	}

	public Member getMember(int i) {
		return memberDao.getMember(i);
	}

}
