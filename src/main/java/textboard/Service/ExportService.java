package textboard.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import textboard.Container.Container;
import textboard.Dto.Article;
import textboard.Dto.Board;
import textboard.Util.exportUtil;

public class ExportService {
	ArticleService articleService;
	MemberService memberService;
	private DisqusService disqusService;

	public ExportService() {
		articleService = Container.articleService;
		memberService = Container.memberService;
		disqusService = Container.disqusService;
	}

	public void makeHtml() {
		exportUtil.mkdirs("site");

		exportUtil.copy("site_template/app.css", "site/app.css");
		exportUtil.copy("site_template/app1.css", "site/app1.css");
		exportUtil.copy("site_template/script.js", "site/javascript.js");
		exportUtil.copy("site_template/top-bar.js", "site/top-bar.js");
		exportUtil.copy("site_template/top-bar.css", "site/top-bar.css");
		loadDisqusData();
		loadDataFromGa4Data();
		buildIndexPage();
		getArticle();
		getList();
		getLoginPage();
		getJoinPage();
		getIntroducePage();
	}

	private void loadDataFromGa4Data() {
		Container.googleAnalyticsApiService.updatePageHits();
	}

	private void loadDisqusData() {
		List<Article> articles = articleService.showList();

		for (Article article : articles) {
			Map<String, Object> disqusArticleData = disqusService.getArticleData(article);

			if (disqusArticleData != null) {
				int likes = (int) disqusArticleData.get("likes");
				int commentsCount = (int) disqusArticleData.get("commentsCount");

				Map<String, Object> modifyArgs = new HashMap<>();
				modifyArgs.put("Num", article.num);
				modifyArgs.put("likes", likes);
				modifyArgs.put("commentsCount", commentsCount);

				articleService.modify(modifyArgs);
			}

		}
	}

	private void getIntroducePage() {
		StringBuilder sb = new StringBuilder();

		exportUtil.mkdirs("site/introducePage");

		String mainHtml = exportUtil.getFileContents("site_template/introducePage/introducePage.html");

		exportUtil.copy("site_template/introducePage/app.css", "site/introducePage/app.css");
		exportUtil.copy("site_template/introducePage/java.js", "site/introducePage/java.js");

		sb.append(mainHtml);

		String filePath = "site/introducePage/introducePage.html";
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + " 생성");
	}

	private void getJoinPage() {
		StringBuilder sb = new StringBuilder();

		String head = getHeadHtml("join");

		String foot = exportUtil.getFileContents("site_template/foot.html");

		String mainHtml = exportUtil.getFileContents("site_template/join.html");

		sb.append(head);

		sb.append(mainHtml);
		sb.append("</header>");
		sb.append("</div>");
		sb.append(foot);

		String filePath = "site/joinPage.html";
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + " 생성");
	}

	private void getLoginPage() {
		StringBuilder sb = new StringBuilder();

		String head = getHeadHtml("login");

		String foot = exportUtil.getFileContents("site_template/foot.html");

		String mainHtml = exportUtil.getFileContents("site_template/loginPage.html");

		sb.append(head);

		sb.append(mainHtml);
		sb.append("</header>");
		sb.append("</div>");
		sb.append(foot);

		String filePath = "site/loginPage.html";
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + " 생성");
	}

	private void getPage(Board board, int pageSize, int pageBoxSize, List<Article> articles, int page) {
		StringBuilder sb = new StringBuilder();

		sb.append(getHeadHtml("article_list_" + board.name));

		String bodyTemplate = exportUtil.getFileContents("site_template/article_list.html");
		sb.append("<div class=\"cover flex flex-column flex-ai-c\">");
		sb.append("<div class=\"listbox-cover\">");
		sb.append("<div class=\"상태\"><h1><i class=\"fas fa-list\"></i> 게시물 리스트</h1></div>");
		sb.append("<div class=\"게시판\"><h2>게시판: " + board.name + "</h2></div>");
		sb.append("<div class=\"글쓰기\"><a href=\"#\"> 글쓰기 </a></div>");

		StringBuilder mainContent = new StringBuilder();

		int articleCnt = articles.size();
		int start = (page - 1) * pageSize;
		int end = start + pageSize - 1;

		if (end >= articleCnt) {
			end = articleCnt - 1;
		}

		for (int i = start; i <= end; i++) {
			Article article = articles.get(i);

			String link = "article_detail_"+article.num + ".html";

			mainContent.append("<div class=\"리스트-리스트\">");
			mainContent.append("<div class=\"리스트 리스트-번호\"><span>" + article.num + "</sapn></div>");
			mainContent.append("<div class=\"리스트 리스트-작성일\"><span>" + article.regDate + "</span></div>");
			mainContent.append("<div class=\"리스트 리스트-작성자\">" + "<a href=\"#\">" + article.extra__writer + "</a></div>");
			mainContent.append("<div class=\"리스트 리스트-제목\">" + "<a href=\"" + link + "\">" + article.title
					+ "</a> <a href=\"#\" class=\"comment-count\"> [" + article.commentsCount + "]</a></div>");
			mainContent.append("<div class=\"리스트 리스트-조회수\"><span>" + article.views + "</span></div>");
			mainContent.append("<div class=\"리스트 리스트-추천수\"><span>" + article.likes + "</span></div>");
			mainContent.append("</div>");
			mainContent.append("</div>");
		}
		StringBuilder pageContent = new StringBuilder();

		int totalPage = (int) Math.ceil(articleCnt / (double) pageSize);

		if (page < 1) {
			page = 1;
		}
		if (page > totalPage) {
			page = totalPage;
		}

		int previousPageBoxCnt = (page - 1) / pageBoxSize;
		int pageBoxStartPage = pageBoxSize * previousPageBoxCnt + 1;
		int pageBoxEndPage = pageBoxStartPage + pageBoxSize - 1;

		if (pageBoxEndPage > totalPage) {
			pageBoxEndPage = totalPage;
		}

		// 이전버튼 페이지 계산

		int pageBoxStartBeforePage = pageBoxStartPage - 1;
		if (pageBoxStartBeforePage < 1) {
			pageBoxStartBeforePage = 1;
		}

		// 다음버튼 페이지 계산

		int pageBoxEndAfterPage = pageBoxEndPage + 1;

		if (pageBoxEndAfterPage > totalPage) {
			pageBoxEndAfterPage = totalPage;
		}

		boolean pageBoxStartBeforeBtnNeedToShow = pageBoxStartBeforePage != pageBoxStartPage;
		boolean pageBoxStartAfterBtnNeedToShow = pageBoxEndAfterPage != pageBoxEndPage;

		if (pageBoxStartBeforeBtnNeedToShow) {
			pageContent.append("<li><article class=\"page page-pre\"><a href=\""
					+ getArticleListFileName(board, pageBoxStartBeforePage) + "\">◀ 이전</a></li>");
		}

		for (int i = pageBoxStartPage; i <= pageBoxEndPage; i++) {
			String selectedClass = "";

			if (i == page) {
				selectedClass = "article-page-menu__link--selected";
			}

			pageContent.append("<li><article class=\"page\"><a href=\"" + getArticleListFileName(board, i)
					+ "\"class=\"" + selectedClass + "\">" + i + "</a></li>");
		}

		if (pageBoxStartAfterBtnNeedToShow) {
			pageContent.append("<li><article class=\"page page-next\"><a href=\""
					+ getArticleListFileName(board, pageBoxEndAfterPage) + "\">▶ 다음</a></li>");
		}

		String body = bodyTemplate.replace("${article-list__main-content}", mainContent.toString());
		body = body.replace("${article-page__list}", pageContent.toString());

		sb.append(body);
		sb.append(exportUtil.getFileContents("site_template/foot.html"));

		String fileName = getArticleListFileName(board, page);
		String filePath = "site/" + fileName;
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + " 생성");
	}

	private String getArticleListFileName(Board board, int page) {
		return "article_list_" + board.name + "_" + page + ".html";
	}

	private void getList() {
		List<Board> boards = articleService.getBoards();

		int articleInAPage = 20;
		int pageSize = 10;

		for (Board board : boards) {

			List<Article> articles = articleService.getArticles(board.boardNum);
			int articlesCount = articles.size();
			int totalPage = (int) Math.ceil((double) articlesCount / articleInAPage);

			for (int i = 1; i <= totalPage; i++) {
				getPage(board, articleInAPage, pageSize, articles, i);
			}
		}
	}

	private void getArticle() {
		List<Board> boards = articleService.getBoards();

		String replyTemplate = exportUtil.getFileContents("site_template/article_reply.html");

		String foot = exportUtil.getFileContents("site_template/foot.html");

		for (Board board : boards) {
			List<Article> articles = articleService.getArticles(board.boardNum);

			for (int i = 0; i < articles.size(); i++) {
				Article article = articles.get(i);
				Article prevArticle = null;

				int prevArticleIndex = i + 1;
				int prevArticleId = 0;

				if (prevArticleIndex < articles.size()) {
					prevArticle = articles.get(prevArticleIndex);
					prevArticleId = prevArticle.num;
				}

				Article nextArticle = null;
				int nextArticleIndex = i - 1;
				int nextArticleId = 0;

				if (nextArticleIndex >= 0) {
					nextArticle = articles.get(nextArticleIndex);
					nextArticleId = nextArticle.num;
				}

				String head = getHeadHtml("article_detail", article);

				StringBuilder sb = new StringBuilder();

				sb.append(head);

				String articleBodyForPrint = article.body;
				articleBodyForPrint = articleBodyForPrint.replaceAll("script", "<!--REPLACE:script-->");
				sb.append("<div class=\"con2\">");
				sb.append("<div class=\"middle-box\">");
				sb.append("<div class=\"마진 상태\"><h1><i class=\"fas fa-search\"></i>게시물 상세보기</h1></div>");
				sb.append("<div class=\"마진 게시판\"><h2>게시판: " + board.code + "</h2></div>");
				sb.append("<div class=\"마진 번호\">게시물 번호: " + article.num + "</div>");

				sb.append("<script type=\"text/x-template=\"><div class=\"ui__제목\">" + article.title + "</div><span class=\"마진 작성일\">작성일: "
						+ article.regDate + "</span>" + "</script>");
				sb.append("<div class=\"제목 toast-ui-viewer viewer\"></div>");
				sb.append("<div class=\"underTitle flex\">");
				sb.append("<span class=\"마진 작성자\">작성자: " + article.extra__writer + "</span>");
				sb.append("<div class=\"flex-grow-1\"></div>");
				sb.append("<span class=\"마진 조회수\">조회수: " + article.views + "</span>");
				sb.append("<span class=\"마진 추천수\">추천수 <i class=\"fas fa-heart\"></i>: " + article.likes + "</span>");
				sb.append("<span class=\"마진 댓글수\">댓글 <i class=\"fas fa-comments\"></i>: " + article.commentsCount
						+ "</span>");
				sb.append("</div>");
				sb.append("<script type=\"text/x-template=\">" + articleBodyForPrint + "</script>");
				sb.append("<div class=\"내용 content toast-ui-viewer\"></div>");
				sb.append("</div>");
				String reply = replyTemplate;
				reply = reply.replace("${site-domain}", "blog.baobab612.com");
				reply = reply.replace("${file-name}", "article_detail_" + article.num + ".html");

				sb.append(reply);

				sb.append("<div class=\"move\">");

				sb.append("</div>");
				sb.append("<div class=\"other\"><h2>이 게시판의 다른 게시물</h2>");
				sb.append("<div class=\"con-min-width2\">");
				sb.append("<header>");
				sb.append("<div class=\"flex 분류-분류\">");
				sb.append("<div class=\"분류1 분류-번호\"><span>번호</span></div>");
				sb.append("<div class=\"분류1 분류-작성일\"><span>작성일</span></div>");
				sb.append("<div class=\"분류1 분류-작성자\"><span>작성자</span></div>");
				sb.append("<div class=\"분류1 분류-제목\"><span>제목</span></div>");
				sb.append("<div class=\"분류1 분류-조회수\"><span>조회수</span></div>");
				sb.append("<div class=\"분류1 분류-추천수\"><span>추천수</span></div>");
				sb.append("</div>");
				sb.append("</header>");
				for (int k = 0; k < articles.size(); k++) {
					Article article1 = articles.get(k);
					if (article.num != article1.num) {
						String link = "article_detail_" + article1.num + ".html";

						sb.append("<div class=\"리스트-리스트\">");
						sb.append("<div class=\"리스트 리스트-번호\"><span>" + article1.num + "</sapn></div>");
						sb.append("<div class=\"리스트 리스트-작성일\"><span>" + article1.regDate + "</span></div>");
						sb.append("<div class=\"리스트 리스트-작성자\">" + "<a href=\"#\">" + article1.extra__writer
								+ "</a></div>");
						sb.append("<div class=\"리스트 리스트-제목\">" + "<a href=\"" + link + "\">" + article1.title
								+ "</a> <a href=\"#\" class=\"comment-count\"> [" + article1.commentsCount
								+ "]</a></div>");
						sb.append("<div class=\"리스트 리스트-조회수\"><span>" + article1.views + "</span></div>");
						sb.append("<div class=\"리스트 리스트-추천수\"><span>" + article1.likes + "</span></div>");
						sb.append("</div>");
					}
				}
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</header>");

				sb.append(foot);
				String fileName = "article_detail_" + article.num + ".html";
				String filePath = "site/" + fileName;
				exportUtil.writeFileContents(filePath, sb.toString());
				System.out.println(filePath + " 생성");
			}

		}
	}

	private void buildIndexPage() {
		StringBuilder sb = new StringBuilder();

		String head = getHeadHtml("index");
		String foot = exportUtil.getFileContents("site_template/foot.html");

		String mainHtml = exportUtil.getFileContents("site_template/index.html");

		sb.append(head);
		sb.append(mainHtml);

		List<Article> articles = articleService.showList();

		for (int i = 0; i < 5; i++) {
			Article article = articles.get(i);

			String link = "article_detail_"+article.num + ".html";

			sb.append("<div class=\"인덱스-리스트\">");
			sb.append("<div class=\"인덱스 인덱스-번호\"><span>" + article.num + "</sapn></div>");
			sb.append("<div class=\"인덱스 인덱스-작성일\"><span>" + article.regDate + "</span></div>");
			sb.append("<div class=\"인덱스 인덱스-게시판\"><span>" + article.extra__board + "</span></div>");
			sb.append("<div class=\"인덱스 인덱스-작성자\">" + "<a href=\"#\">" + article.extra__writer + "</a></div>");
			sb.append("<div class=\"인덱스 인덱스-제목\">" + "<a href=\"" + link + "\">" + article.title
					+ "</a> <a href=\"#\" class=\"comment-count\">[" + article.commentsCount + "]</a></div>");
			sb.append("<div class=\"인덱스 인덱스-조회수\"><span>" + article.views + "</span></div>");
			sb.append("<div class=\"인덱스 인덱스-추천수\"><span>" + article.likes + "</span></div>");
			sb.append("</div>");
		}

		sb.append("</div>");
		sb.append("</div>");
		sb.append("</header>");
		sb.append(foot);

		String filePath = "site/index.html";
		exportUtil.writeFileContents(filePath, sb.toString());

		System.out.println(filePath + " 생성");
	}

	private String getHeadHtml(String pageName, Object relObj) {
		String head = exportUtil.getFileContents("site_template/head.html");
		StringBuilder boardMenuContentHtml = new StringBuilder();

		List<Board> boards = articleService.getBoards();
		int turn = 2;
		for (Board board : boards) {

			if (board.boardNum <= 3) {
				String pageTitle = getPageTitle(pageName, relObj);

				head = head.replace("{page-title}", pageTitle);

				boardMenuContentHtml.append("<li class =\"flex flex-ai-c height-100p\">");

				String link = getArticleListFileName(board, 1);
				if (board.boardNum == 2) {
					link = "article_list_Java_1.html";
				}

				String[] boardName = board.name.split("");
				boardMenuContentHtml.append("<a href=\"" + link + "\" class=\"word" + turn + "\">");
				for (int i = 0; i < boardName.length; i++) {
					boardMenuContentHtml.append("<span class=a__" + (i + 1) + ">" + boardName[i] + "</span>");
				}
				boardMenuContentHtml.append("</a>");
				turn++;
				if (board.boardNum == 2) {
					boardMenuContentHtml.append("<ul class=\"snip1284\"style=\"z-index:999\">");
					boardMenuContentHtml.append("${board_menu2}");
					boardMenuContentHtml.append("</ul>");
				}
			}
			boardMenuContentHtml.append("</li>");
		}
		head = head.replace("${board_menu}", boardMenuContentHtml.toString());

		StringBuilder boardMenuContentHtml1 = new StringBuilder();
		for (int k = 3; k < boards.size(); k++) {
			Board board = boards.get(k);
			String link = getArticleListFileName(board, 1);

			boardMenuContentHtml1.append("<li>");
			boardMenuContentHtml1.append("<a href=\"" + link + "\">" + board.name + "</a>");
			boardMenuContentHtml1.append("</li>");

		}
		head = head.replace("${board_menu2}", boardMenuContentHtml1.toString());
		String titleBarContentHtml = getTitleBarContentByFileName(pageName);

		head = head.replace("${title-bar}", titleBarContentHtml);

		String siteName = "바오밥 블로그";
		String subject = "오밥이의 공부 블로그";
		String siteDescription = "오밥이의 공부 내용이 올라오는 블로그.";
		String siteDomain = "blog.baobab612.com";
		String siteMainUrl = "https://blog.baobab612.com";
		String currentDate = exportUtil.getNowDateStr().replace("", "T");

		head = head.replace("{site-name}", siteName);
		head = head.replace("{site-domain}", siteDomain);
		head = head.replace("{site-subject}", subject);
		head = head.replace("{site-description}", siteDescription);
		head = head.replace("{site-domain}", siteDomain);
		head = head.replace("{current-date}", currentDate);
		head = head.replace("{site-main-url}", siteMainUrl);
		return head;
	}

	private String getHeadHtml(String pageName) {
		return getHeadHtml(pageName, null);
	}

	private String getPageTitle(String pageName, Object relObj) {
		StringBuilder sb = new StringBuilder();

		String forPrintPageName = pageName;

		List<Board> boards = articleService.getBoards();
		if (forPrintPageName.equals("index")) {
			forPrintPageName = " HOME";
		} else if (forPrintPageName.equals("article_detail")) {
			forPrintPageName = " List";
		} else if (forPrintPageName.contains("article_list_")) {
			forPrintPageName = forPrintPageName.replace("article_list_", " ");
		} else if (forPrintPageName.contains("join")) {
			forPrintPageName = " 회원가입";
		} else if (forPrintPageName.contains("login")) {
			forPrintPageName = " 로그인 페이지";
		}

		sb.append("바오밥 블로그 |" + forPrintPageName);
		if (relObj instanceof Article) {
			Article article = (Article) relObj;
			sb.insert(0, article.title + " | ");
		}
		return sb.toString();
	}

	private String getTitleBarContentByFileName(String pageName) {

		return "";
	}

	public String getArticleFileName(int num) {
		return "article_detail_" +num + ".html";
	}
}
