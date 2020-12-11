package textboard.Controller;

import java.util.Scanner;

import textboard.Container.Container;
import textboard.Dto.Member;
import textboard.Service.MemberService;

public class MemberController extends Controller {

	MemberService memberService;
	int limit;

	public MemberController() {
		memberService = Container.memberService;
		limit = 3;
	}

	public void run(String cmd) {
		Scanner sc = Container.sc;
		if (cmd.equals("member join")) {
			if (Container.session.loginId > 0) {
				System.out.println("로그아웃 후 이용해주세요.");
			}
			System.out.println("== 회원 가입 ==");
			int count = 0;
			while (true) {
				if (count == limit) {
					System.out.println("3회 틀리셨습니다. 잠시 후 이용해주세요.");
					break;
				}
				System.out.printf("성명: ");
				String name = sc.nextLine().trim();
				System.out.printf("아이디: ");
				String id = sc.nextLine().trim();
				int idCheck = memberService.idCheck(id);

				if (idCheck == -1) {
					System.out.println("이미 아이디가 존재합니다.");
					count++;
					continue;
				}
				if (idCheck == -2) {
					System.out.println("아이디 중간에 공백이 있어서는 안됩니다.");
					count++;
					continue;
				}
				if (idCheck == -1) {
					System.out.println("아이디는 두글자 이상이어야 합니다.");
					count++;
					continue;
				}
				System.out.printf("패스워드: ");
				String password = sc.nextLine().trim();

				int pwCheck = memberService.pwCheck(password);

				if (pwCheck == -1) {
					System.out.println("아이디 중간에 공백이 있어서는 안됩니다.");
					count++;
					continue;
				}
				if (pwCheck == -2) {
					System.out.println("아이디는 두글자 이상이어야 합니다.");
					count++;
					continue;
				}
				int i = memberService.join(name, id, password);

				System.out.printf("회원가입 되었습니다. 회원 번호 %d\n", i);
				break;
			}
		} else if (cmd.equals("member login")) {
			int count = 0;
			if (Container.session.loginId > 0) {
				System.out.println("이미 로그인상태입니다.");
			}
			System.out.println("== 로그인 화면 ==");
			while (true) {
				if (count == limit) {
					System.out.println("3회 틀리셨습니다. 잠시 후 이용해주세요.");
					break;
				}
				System.out.printf("로그인 아이디: ");
				String id = sc.nextLine().trim();
				Member member = memberService.getMemberId(id);
				if (member == null) {
					System.out.println("존재하지 않는 아이디 입니다.");
					count++;
					continue;
				}
				System.out.printf("로그인 패스워드: ");
				String password = sc.nextLine().trim();
				if (member.password.equals(password) == false) {
					System.out.println("패스워드가 일치하지 않습니다.");
					count++;
					continue;
				}
				if (member.memberNum != 999) {
					System.out.println("로그인이 완료되었습니다. 회원번호 : " + member.memberNum);
				} else if (member.memberNum == 999) {
					System.out.println("관리자 모드로 접속 됐습니다.");
				}
				Container.session.loginId = member.memberNum;
				break;
			}
		} else if (cmd.equals("member logout")) {
			if (Container.session.loginId == 0) {
				System.out.println("이미 로그아웃 상태입니다.");
			}
			Container.session.loginId = 0;
			System.out.println("로그아웃 되었습니다.");
		} else if (cmd.equals("member whoami")) {
			if (Container.session.loginId == 0) {
				System.out.println("로그인 후 이용 해주세요.");
				return;
			}
			Member member = memberService.getMember(Container.session.loginId);
			System.out.println("== 회원 정보 ==");
			if (member.memberNum == 999) {
				System.out.println("관리자 모드에서는 실행하지 않는 명령입니다.");
				return;
			}
			System.out.println("회원 번호: " + member.memberNum);
			System.out.println("이름: " + member.name);
			System.out.println("아이디: " + member.id);
		}
	}
}
