package textboard.Controller;

import java.util.List;
import java.util.Scanner;

import textboard.Container.Container;
import textboard.Dto.Article;
import textboard.Dto.Board;
import textboard.Dto.Member;
import textboard.Dto.Reply;
import textboard.Service.ArticleService;
import textboard.Service.MemberService;

public class ArticleController extends Controller {
	ArticleService articleService;
	MemberService memberService;

	public ArticleController() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void run(String cmd) {
		Scanner sc = Container.sc;
		if (cmd.equals("article list")) {

			List<Article> lists = articleService.showList();
			List<Board> boards = articleService.getBoards();
			if (lists.size() < 1) {
				System.out.println("등록된 게시물이 없습니다.");
				return;
			}
			System.out.printf("== %s ==\n", boards.get(Container.session.selectBoardNum - 1).name);
			System.out.println("번호 / 제목 / 작성자");
			for (int i = 0; i < lists.size(); i++) {
				Article article = lists.get(i);
				if (article.boardNum == Container.session.selectBoardNum) {
					System.out.printf("%d / %s / %s \n", article.num, article.title, article.extra__writer);
				}
			}
		} else if (cmd.startsWith("article detail ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);

			List<Reply> replies = articleService.getReplies();

			List<Article> lists = articleService.showList();

			Article article = lists.get(inputedId - 1);

			if (article == null) {
				System.out.println("존재하지 않는 게시물 입니다.");
				return;
			}
			int k = articleService.addViews(inputedId);

			System.out.printf("== %s ==\n", article.extra__board);

			System.out.println("번호 / 조회수 / 추천수 / 작성자 / 작성일자 / 수정일자 / 제목 / 내용");
			System.out.printf("%d / %d / %d / %s / %s / %s / %s / %s \n", article.num, k, article.likes,
					article.extra__writer, article.regDate, article.updateDate, article.title, article.body);
			if (article.commentsCount == 0) {
				System.out.println("작성된 댓글 없음");
				return;
			}
			System.out.println("작성된 댓글");
			for (int i = 0; i < replies.size(); i++) {
				if (replies.get(i).articleNum == article.num) {
					System.out.printf("%d, %s: %s\n", i + 1, replies.get(i).name, replies.get(i).body);
				}
			}
		} else if (cmd.startsWith("article delete ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);

			Article article = articleService.getArticle(inputedId);
			Member member = memberService.getMember(Container.session.loginId);
			if (member.name.equals("방혜성") == false || member.id.equals("baobab612") == false) {
				System.out.println("접근 권한이 없습니다.");
				return;
			}

			if (member.name.equals("방혜성") && member.id.equals("baobab612")) {
				System.out.println("관리자 권한으로 삭제하시겠습니까 Y/N");
				System.out.printf("명령어) ");
				String answer = sc.nextLine();
				if (answer.equals("N")) {
					System.out.println("삭제 취소 되었습니다.");
					return;
				}
			}
			articleService.delete(inputedId);

			System.out.printf("%d번 게시물이 삭제되었습니다.\n", inputedId);
		} else if (cmd.equals("article add")) {

			System.out.printf("제목: ");
			String head = sc.nextLine();
			System.out.printf("내용: ");
			String body = sc.nextLine();

			int i = articleService.write(Container.session.loginId, Container.session.selectBoardNum, head, body);

			System.out.printf("%d번 게시물이 추가되었습니다.\n", i);
		} else if (cmd.startsWith("article modify ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);
			Article article = articleService.getArticle(inputedId);

			if (article.memberNum != Container.session.loginId - 1) {
				System.out.println("접근 권한이 없습니다.");
				return;
			}
			System.out.printf("제목: ");
			String head = sc.nextLine();
			System.out.printf("내용: ");
			String body = sc.nextLine();

			articleService.modify(inputedId, head, body);

			System.out.printf("%d번 게시물이 수정되었습니다.\n", inputedId);
		} else if (cmd.equals("article boardAdd")) {
			System.out.println("== 게시판 추가 ==");

			System.out.printf("생성할 게시판 이름: ");
			String name = sc.nextLine();

			System.out.printf("코드 이름: ");
			String code = sc.nextLine();
			
			int i = articleService.addBoard(Container.session.loginId, name, code);
			if (i == -1) {
				System.out.println("관리자만 게시판을 추가할 수 있습니다.");
				return;
			}
			System.out.println("게시판이 생성 되었습니다. 게시판 번호 : " + i);
		} else if (cmd.startsWith("article boardSelect ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);

			List<Board> boards = articleService.getBoards();

			if (inputedId > boards.size() || inputedId < 0) {
				System.out.println("게시판이 존재하지 않습니다.");
				return;
			}
			Container.session.selectBoardNum = inputedId;
			System.out.println("게시판이 선택 되었습니다.");
			System.out.println("선택된 게시판 이름: " + boards.get(inputedId - 1).name);
		} else if (cmd.equals("article current board")) {
			List<Board> boards = articleService.getBoards();

			System.out.println("현재 게시판 : " + boards.get(Container.session.selectBoardNum - 1).name);
		} else if (cmd.startsWith("article reply ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);
			int count = 0;
			List<Article> articles = articleService.getArticles();
			for (int i = 0; i < articles.size(); i++) {
				if (articles.get(i).num == inputedId) {
					count++;
				}
			}
			if (inputedId > articles.size() || inputedId < 0 || count == 0) {
				System.out.println("게시물이 존재하지 않습니다.");
				return;
			}
			System.out.println("== 댓글 등록 ==");
			System.out.printf("내용: ");
			String body = sc.nextLine();
			Member member = memberService.getMember(Container.session.loginId);

			int i = articleService.writeReply(member.name, inputedId, body);

			System.out.printf("%d번 댓글이 작성되었습니다.\n", i);
		} else if (cmd.startsWith("article recommand ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);

			int i = articleService.recommand(Container.session.loginId, inputedId);

			if (i == -1) {
				System.out.println("중복 추천은 불가능합니다.");
				return;
			}
			if (i == -2) {
				System.out.println("존재하지 않는 게시물 입니다.");
				return;
			}
			System.out.println("게시물이 추천되었습니다.");
		} else if (cmd.startsWith("article cancelRecommand ")) {
			int inputedId = Integer.parseInt(cmd.split(" ")[2]);

			int i = articleService.cancelRecommand(Container.session.loginId, inputedId);

			if (i == -1) {
				System.out.println("해당 게시물의 추천 기록이 없습니다.");
				return;
			}
			if (i == -2) {
				System.out.println("존재하지 않는 게시물 입니다.");
				return;
			}
			System.out.println("게시물 추천이 취소되었습니다.");
		}

	}
}
