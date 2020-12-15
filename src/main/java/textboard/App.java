package textboard;

import java.util.Scanner;

import textboard.Container.Container;
import textboard.Controller.ArticleController;
import textboard.Controller.Controller;
import textboard.Controller.ExportController;
import textboard.Controller.MemberController;
import textboard.Service.ArticleService;
import textboard.Service.MemberService;
import textboard.Util.MysqlUtil;

public class App {
	MemberService memberService;
	ArticleService articleService;
	ArticleController articleController;
	MemberController memberController;
	ExportController exportController;

	public App() {
		articleService = Container.articleService;
		memberService = Container.memberService;
		articleController = Container.articleController;
		memberController = Container.memberController;
		exportController = Container.exportController;
		init();
	}

	public void run() {
		Scanner sc = Container.sc;

		while (true) {

			System.out.printf("명령어) ");

			String cmd = sc.nextLine();

			MysqlUtil.setDBInfo("localhost", "root", "", "a2");

			boolean exit = false;

			Controller controller = cmdRun(cmd);
			if (controller == null) {
				continue;
			}
			controller.run(cmd);

			if (cmd.equals("exit")) {
				System.out.println("프로그램 종료");
				exit = true;
			}
			MysqlUtil.closeConnection();
			if (exit) {
				break;
			}
		}
	}

	private void init() {

		if (Container.session.selectBoardNum == 0) {
			Container.session.selectBoardNum = 1;
		}

	}

	private Controller cmdRun(String cmd) {
		if (cmd.startsWith("article ")) {
			if (Container.session.loginId == 0) {
				System.out.println("로그인 후 이용해주세요");
				return null;
			}
			return articleController;
		} else if (cmd.startsWith("member ")) {
			return memberController;
		} else if (cmd.startsWith("export ")) {
			return exportController;
		}
		return null;
	}

}
