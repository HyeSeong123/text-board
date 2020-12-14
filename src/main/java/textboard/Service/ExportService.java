package textboard.Service;

import java.util.ArrayList;
import java.util.List;

import textboard.Container.Container;
import textboard.Dto.Article;
import textboard.Dto.Board;
import textboard.Util.exportUtil;

public class ExportService {
	ArticleService articleService;
	MemberService memberService;

	public ExportService() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void makeHtml() {
		exportUtil.mkdirs("site");

		exportUtil.copy("site_template/app.css", "site/app.css");

		buildIndexPage();
		getArticle();
		getList();
	}

	private void getList() {
		List<Article> articles = articleService.showList();
		List<Board> boards = articleService.getBoards();

		String head = getHeadHtml("article_list");
		String foot = exportUtil.getFileContents("site_template/foot.html");

		int page = articles.size() / 10;

		for (Board board : boards) {
			StringBuilder sb = new StringBuilder();
			sb.append(head);
			sb.append("<div class=\"상태\"><h1><i class=\"fas fa-list\"></i> 게시물 리스트</h1></div>");
			sb.append("<div class=\"게시판\"><h2>게시판: " + board.name + "</h2></div>");
			int i = 0;
			for (Article article : articles) {
				if (i == 0) {
					sb.append("<div class=\"분류\">");
					sb.append("<div class=\"분류1 분류-번호\">번호</div>");
					sb.append("<div class=\"분류1 분류-작성일\">작성일</div>");
					sb.append("<div class=\"분류1 분류-작성자\">작성자</div>");
					sb.append("<div class=\"분류1 분류-제목\">제목</div>");
					sb.append("<div class=\"분류1 분류-조회수\">조회수</div>");
					sb.append("<div class=\"분류1 분류-추천수\">추천수</div>");
					sb.append("</div>");
					i++;
				}
				if (board.name.equals(article.extra__board)) {
					sb.append("<div class=\"리스트-리스트\">");
					sb.append("<div class=\"리스트 리스트-번호\"><span>" + article.num + "</sapn></div>");
					sb.append("<div class=\"리스트 리스트-작성일\"><span>" + article.regDate + "</span></div>");
					sb.append("<div class=\"리스트 리스트-작성자\">" + "<a href=\"#\">" + article.extra__writer + "</a></div>");
					sb.append("<div class=\"리스트 리스트-제목\">" + "<a href=\"" + article.num + ".html\">" + article.title
							+ "asddsaasddasdadas</a> <span> [" + article.replyNum + "]</span></div>");
					sb.append("<div class=\"리스트 리스트-조회수\"><span>" + article.views + "</span></div>");
					sb.append("<div class=\"리스트 리스트-추천수\"><span>" + article.recommadNum + "</span></div>");
					sb.append("</div>");
				}
			}
			sb.append("</header>");
			sb.append(foot);

			String fileName = board.name + ".html";
			String filePath = "site/" + fileName;
			exportUtil.writeFileContents(filePath, sb.toString());
			System.out.println(filePath + " 생성");

		}

	}

	private void getArticle() {

		List<Article> articles = articleService.showList();

		String head = getHeadHtml("article_detail");
		String foot = exportUtil.getFileContents("site_template/foot.html");
		int i = 0;

		for (Article article : articles) {

			StringBuilder sb = new StringBuilder();

			List<Article> board1 = new ArrayList<Article>();
			List<Article> board2 = new ArrayList<Article>();
			List<Article> board3 = new ArrayList<Article>();

			for (int k = 0; k < articles.size(); k++) {
				if (articles.get(k).boardNum == 1) {
					board1.add(articles.get(k));
				} else if (articles.get(k).boardNum == 2) {
					board2.add(articles.get(k));
				} else if (articles.get(k).boardNum == 3) {
					board3.add(articles.get(k));
				}
			}

			sb.append(head);

			sb.append("<div class=\"상태\"><h1><i class=\"fas fa-search\"></i>게시물 상세보기</h1></div>");
			sb.append("<div class=\"게시판\"><h2>게시판: " + article.extra__board + "</h2></div>");
			sb.append("<div class=\"번호\">게시물 번호: " + article.num + "</div>");
			sb.append("<div class=\"작성일\">작성일: " + article.regDate + "</div>");
			sb.append("<div class=\"작성자\">작성자: " + article.extra__writer + "</div>");
			sb.append("<div class=\"조회수\">조회수: " + article.views + "</div>");
			sb.append("<div class=\"추천수\">추천수: " + article.recommadNum + "</div>");
			sb.append("<div class=\"댓글수\">댓글수: " + article.replyNum + "</div>");
			sb.append("<div class=\"제목\">게시물 제목: " + article.title + "</div>");
			sb.append("<div class=\"내용\">" + article.body + "</div>");
			sb.append("<div class=\"move\">");

			if (article.boardNum == 1) {
				for (int k = 0; k < board1.size(); k++) {
					if (board1.get(k).num == article.num) {

						if (k < board1.size() - 1) {
							sb.append("<div class=\"pre\"><a href=\"" + (board1.get(k + 1).num)
									+ ".html\">◀이전글</a></div>");
						}
						if (k > 0) {
							sb.append("<div class=\"next\"><a href=\"" + (board1.get(k - 1).num)
									+ ".html\">다음글▶</a></div>");
						}
					}
				}
			} else if (article.boardNum == 2) {
				for (int k = 0; k < board2.size(); k++) {
					if (board2.get(k).num == article.num) {
						if (k < board2.size() - 1) {
							sb.append("<div class=\"pre\"><a href=\"" + (board2.get(k + 1).num)
									+ ".html\">◀이전글</a></div>");
						}
						if (k > 0) {
							sb.append("<div class=\"next\"><a href=\"" + (board2.get(k - 1).num)
									+ ".html\">다음글▶</a></div>");
						}
					}
				}
			} else if (article.boardNum == 3) {
				for (int k = 0; k < board3.size(); k++) {
					if (board3.get(k).num == article.num) {
						if (k < board3.size() - 1) {
							sb.append("<div class=\"pre\"><a href=\"" + (board3.get(k + 1).num)
									+ ".html\">◀이전글</a></div>");
						}
						if (k > 0) {
							sb.append("<div class=\"next\"><a href=\"" + (board3.get(k - 1).num)
									+ ".html\">다음글▶</a></div>");
						}
					}
				}
			}

			sb.append("</div>");

			sb.append("</header>");
			sb.append(foot);

			String fileName = article.num + ".html";
			String filePath = "site/" + fileName;
			exportUtil.writeFileContents(filePath, sb.toString());
			System.out.println(filePath + " 생성");
			i++;
		}

	}

	private void buildIndexPage() {
		StringBuilder sb = new StringBuilder();

		String head = getHeadHtml("index");
		String foot = exportUtil.getFileContents("site_template/foot.html");

		String mainHtml = exportUtil.getFileContents("site/template/index.html");

		sb.append(head);
		sb.append(mainHtml);
		sb.append("</div>");
		sb.append("</header>");
		sb.append(foot);

		String filePath = "site/index.html";
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + " 생성");
	}

	private String getHeadHtml(String pageName) {
		String head = exportUtil.getFileContents("site_template/head.html");
		StringBuilder boardMenuContentHtml = new StringBuilder();

		List<Board> boards = articleService.getBoards();

		for (Board board : boards) {
			boardMenuContentHtml.append("<li>");

			String link = board.name + ".html";

			boardMenuContentHtml.append("<a href=\"" + link + "\">" + board.name + "</a>");

			String iClass = "fab fa-free-code-camp";

			boardMenuContentHtml.append("</li>");

		}

		head = head.replace("${board_menu}", boardMenuContentHtml.toString());

		String titleBarContentHtml = getTitleBarContentByFileName(pageName);

		head = head.replace("${title-bar}", titleBarContentHtml);
		return head;
	}

	private String getTitleBarContentByFileName(String pageName) {

		if (pageName.equals("index")) {
			return "<i class=\"fas fa-home\"></i> <span>HOME</span>";
		}
		return "";
	}
}
