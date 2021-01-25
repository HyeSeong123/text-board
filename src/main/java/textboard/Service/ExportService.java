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
		exportUtil.copy("site_template/script.js", "site/javascript.js");
		exportUtil.copy("site_template/top-bar.js", "site/top-bar.js");
		exportUtil.copy("site_template/list_gsap.js", "site/list_gsap.js");
		exportUtil.copy("site_template/top-bar.css", "site/top-bar.css");
		exportUtil.copy("site_template/sidebar.css", "site/sidebar.css");
		loadDisqusData();
		loadDataFromGa4Data();
		buildIndexPage();
		getArticle();
		getList();
		buildArtcileSearchPage();
		getLoginPage();
		getJoinPage();
		getIntroducePage();
	}

	private void buildArtcileSearchPage() {
		List<Article> articles = articleService.showList();
		String jsonText = exportUtil.getJsonText(articles);
		exportUtil.writeFileContents("site/article_list.json", jsonText);
		exportUtil.copy("site_template/article_search.js", "site/article_search.js");

		StringBuilder sb = new StringBuilder();

		String head = getHeadHtml("article_search");
		String foot = exportUtil.getFileContents("site_template/foot.html");

		String html = exportUtil.getFileContents("site_template/article_search.html");

		sb.append(head);
		sb.append(html);
		sb.append(foot);

		String filePath = "site/article_search.html";
		exportUtil.writeFileContents(filePath, sb.toString());
		System.out.println(filePath + "생성");

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
				modifyArgs.put("Num", article.getNum());
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

		sb.append(getHeadHtml("article_list_" + board.getName()));

		String bodyTemplate = exportUtil.getFileContents("site_template/article_list.html");
		sb.append("<div class=\"flex flex-column flex-ai-c\">");
		sb.append("<div class=\"shooting-cover\">");
		sb.append("<div class=\"shooting-stars\">");
		sb.append("<div class=\"shooting-star\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--mid\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--mid1\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--mid2\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--mid3\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--mid4\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--fast\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--fast1\"></div>");
		sb.append("<div class=\"shooting-star shooting-star--meh\"></div>");
		sb.append("</div>");
		sb.append("<div class=\"listbox-cover flex flex-column flex-ai-c\">");
		sb.append("<div class=\"상태\"><h1><i class=\"fas fa-list\"></i> 게시물 리스트</h1></div>");
		sb.append("<div class=\"게시판\"><h2>게시판: " + board.getName() + "</h2></div>");

		StringBuilder mainContent = new StringBuilder();

		int articleCnt = articles.size();
		int start = (page - 1) * pageSize;
		int end = start + pageSize - 1;

		if (end >= articleCnt) {
			end = articleCnt - 1;
		}

		for (int i = start; i <= end; i++) {
			Article article = articles.get(i);

			String link = " article_detail_" + article.getNum() + ".html";

			/*
			 * if (i % 2 == 0) { mainContent.append("<a href=\"" + link +
			 * "\" class=\"balloon__a balloon-left balloon" + (i + 1) + link + "\">");
			 * 
			 * } else if (i % 2 != 0) { mainContent.append("<a href=\"" + link +
			 * "\" class=\"balloon__a balloon-right balloon" + (i + 1) + link + "\">"); }
			 * 
			 * mainContent.append("<div class=\"balloon" + "\">");
			 */

			mainContent.append("<a href=\"" + link + "\" class=\"balloon__a balloon" + (i + 1) + link + "\">");
			mainContent.append("<div class=\"balloon-left balloon" + "\">");

			mainContent.append("<div class=\"balloon__작성일\">작성일: " + article.getRegDate() + "</div>");
			mainContent.append("<div class=\"balloon__작성자\">작성자: " + article.getExtra__writer() + "</div>");
			mainContent.append("<div class=\"balloon__제목\">제목: " + article.getTitle() + "</div>");
			mainContent.append("<div class=\"balloon__댓글\"><i class=\"fas fa-comments\"></i> 댓글 수: "
					+ article.getCommentsCount() + "</div>");
			mainContent.append("<div class=\"balloon__추천\"><i class=\"fas fa-heart\"></i>추천 수: " + "<span>"
					+ article.getLikes() + "</span></div>");
			mainContent.append("<div class=\"balloon__조회\">조회수: " + article.getViews() + "</div>");
			mainContent.append("</div>");
			mainContent.append("</a>");
		}
		mainContent.append("</div>");
		mainContent.append("</div>");
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
		return "article_list_" + board.getName() + "_" + page + ".html";
	}

	private void getList() {
		List<Board> boards = articleService.getBoards();

		int articleInAPage = 20;
		int pageSize = 10;

		for (Board board : boards) {

			List<Article> articles = articleService.getArticles(board.getBoardNum());
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
			List<Article> articles = articleService.getArticles(board.getBoardNum());

			for (int i = 0; i < articles.size(); i++) {
				Article article = articles.get(i);
				Article prevArticle = null;

				int prevArticleIndex = i + 1;
				int prevArticleId = 0;

				if (prevArticleIndex < articles.size()) {
					prevArticle = articles.get(prevArticleIndex);
					prevArticleId = prevArticle.getNum();
				}

				Article nextArticle = null;
				int nextArticleIndex = i - 1;
				int nextArticleId = 0;

				if (nextArticleIndex >= 0) {
					nextArticle = articles.get(nextArticleIndex);
					nextArticleId = nextArticle.getNum();
				}

				String head = getHeadHtml("article_detail", article);

				StringBuilder sb = new StringBuilder();
						
				sb.append(head);

				String articleBodyForPrint = article.getBody();
				articleBodyForPrint = articleBodyForPrint.replaceAll("script", "<!--REPLACE:script-->");
				
				sb.append("<div class=\"ad_margin\"></div>");
				sb.append(
						"<script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script> ");
				sb.append(
						"<ins class=\"adsbygoogle\" style=\"display:block; text-align:center;\" data-ad-layout=\"in-article\" data-ad-format=\"fluid\" data-ad-client=\"ca-pub-6509950454554885\" data-ad-slot=\"5923605860\">");
				sb.append("</ins>");
				sb.append("<script>");
				sb.append("(adsbygoogle = window.adsbygoogle || []).push({});");
				sb.append("</script>");
				
				sb.append("<div class=\"con2\">");
				sb.append("<div class=\"middle-box\">");
				sb.append("<div class=\"마진 상태\"><h1><i class=\"fas fa-search\"></i>게시물 상세보기</h1></div>");
				sb.append("<div class=\"마진 게시판\"><h2>게시판: " + board.getCode() + "</h2></div>");

				sb.append("<script type=\"text/x-template=\"><div class=\"ui__제목\">" + article.getTitle()
						+ "</div><span class=\"마진 작성일\">작성일: " + article.getRegDate() + "</span>" + "</script>");
				sb.append("<div class=\"제목 toast-ui-viewer viewer\"></div>");
				sb.append("<div class=\"underTitle flex\">");
				sb.append("<span class=\"마진 작성자\">작성자: " + article.getExtra__writer() + "</span>");
				sb.append("<div class=\"flex-grow-1\"></div>");
				sb.append("<span class=\"마진 조회수\">조회수: " + article.getViews() + "</span>");
				sb.append(
						"<span class=\"마진 추천수\">추천수 <i class=\"fas fa-heart\"></i>: " + article.getLikes() + "</span>");
				sb.append("<span class=\"마진 댓글수\">댓글 <i class=\"fas fa-comments\"></i>: " + article.getCommentsCount()
						+ "</span>");
				sb.append("</div>");
				sb.append("<script type=\"text/x-template=\">" + articleBodyForPrint + "</script>");
				sb.append("<div class=\"내용 content toast-ui-viewer\"></div>");
				sb.append("</div>");
				String reply = replyTemplate;
				reply = reply.replace("${site-domain}", "blog.baobab612.com");
				reply = reply.replace("${file-name}", "article_detail_" + article.getNum() + ".html");

				sb.append(reply);

				sb.append("<div class=\"move\">");

				sb.append("</div>");
				sb.append("<div class=\"other table-cover\"><h2>이 게시판의 다른 게시물</h2>");
				sb.append("<table border=\"2\">");
				sb.append("<thead>");
				sb.append("<tr>");
				sb.append("<th><span>번호</span></th>");
				sb.append("<th><span>작성일</span></th>");
				sb.append("<th><span>작성자</span></th>");
				sb.append("<th><span>제목</span></th>");
				sb.append("<th><span>조회수</span></th>");
				sb.append("<th><span>추천수</span></th>");
				sb.append("</tr>");
				sb.append("</thead>");
				sb.append("<tbody>");

				for (int k = 0; k < articles.size(); k++) {
					Article article1 = articles.get(k);
					if (article.getNum() != article1.getNum()) {
						String link = "article_detail_" + article1.getNum() + ".html";
						sb.append("<tr>");
						sb.append("<th class=\"\"><span>" + article1.getNum() + "</sapn></th>");
						sb.append("<th class=\"\"><span>" + article1.getRegDate() + "</span></th>");
						sb.append("<th class=\"\">" + "<a href=\"#\">" + article1.getExtra__writer() + "</a></th>");
						sb.append("<th class=\"table__title\">" + "<a href=\"" + link + "\">" + article1.getTitle()
								+ "</a> <a href=\"#\" class=\"comment-count\"> [" + article1.getCommentsCount()
								+ "]</a></th>");
						sb.append("<th class=\"\"><span>" + article1.getViews() + "</span></th>");
						sb.append("<th class=\"\"><span>" + article1.getLikes() + "</span></th>");
						sb.append("</tr>");

					}
				}
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div>");
				sb.append("</div>");
				
				sb.append(
						"<script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script> ");
				sb.append(
						"<ins class=\"adsbygoogle\" style=\"display:block; text-align:center;\" data-ad-layout=\"in-article\" data-ad-format=\"fluid\" data-ad-client=\"ca-pub-6509950454554885\" data-ad-slot=\"7705275603\">");
				sb.append("</ins>");
				sb.append("<script>");
				sb.append("(adsbygoogle = window.adsbygoogle || []).push({});");
				sb.append("</script>");
				
				sb.append(foot);
				String fileName = "article_detail_" + article.getNum() + ".html";
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

		sb.append("<tbody>");
		for (int i = 0; i < 5; i++) {
			Article article = articles.get(i);

			String link = "article_detail_" + article.getNum() + ".html";

			sb.append("<tr>");
			sb.append("<th class=\"\"><span>" + article.getNum() + "</sapn></th>");
			sb.append("<th class=\"\"><span>" + article.getRegDate() + "</sapn></th>");
			sb.append("<th class=\"\"><span>" + article.getExtra__boardName() + "</span></th>");
			sb.append("<th class=\"table__writer\">" + "<a href=\"#\">" + article.getExtra__writer() + "</a></th>");
			sb.append("<th class=\"table__title\">" + "<a href=\"" + link + "\">" + article.getTitle()
					+ "</a> <a href=\"#\" class=\"comment-count\">[" + article.getCommentsCount() + "]</a></th>");
			sb.append("<th class=\"인덱스 인덱스-조회수\"><span>" + article.getViews() + "</span></th>");
			sb.append("<th class=\"인덱스 인덱스-추천수\"><span>" + article.getLikes() + "</span></th>");
			sb.append("</tr>");
		}

		sb.append("</table>");
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

			if (board.getBoardNum() <= 3) {
				String pageTitle = getPageTitle(pageName, relObj);

				head = head.replace("{page-title}", pageTitle);

				boardMenuContentHtml.append("<li class =\"flex flex-ai-c height-100p\">");

				String link = getArticleListFileName(board, 1);
				if (board.getBoardNum() == 2) {
					link = "article_list_Java_1.html";
				}

				String[] boardName = board.getName().split("");
				boardMenuContentHtml.append("<a href=\"" + link + "\" class=\"word" + turn + "\">");
				for (int i = 0; i < boardName.length; i++) {
					boardMenuContentHtml.append("<span class=a__" + (i + 1) + ">" + boardName[i] + "</span>");
				}
				boardMenuContentHtml.append("</a>");
				turn++;
				if (board.getBoardNum() == 2) {
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
			boardMenuContentHtml1.append("<a href=\"" + link + "\">" + board.getName() + "</a>");
			boardMenuContentHtml1.append("</li>");

		}
		head = head.replace("${board_menu2}", boardMenuContentHtml1.toString());

		int side_turn = 2;
		StringBuilder sideMenuContentHtml = new StringBuilder();
		for (Board board : boards) {

			if (board.getBoardNum() <= 3) {
				String pageTitle = getPageTitle(pageName, relObj);

				head = head.replace("{page-title}", pageTitle);

				sideMenuContentHtml.append("<li class =\"sidebar__li\">");

				String link = getArticleListFileName(board, 1);
				if (board.getBoardNum() == 2) {
					link = "article_list_Java_1.html";
				}

				String[] boardName = board.getName().split("");
				sideMenuContentHtml.append("<a href=\"" + link + "\">");
				sideMenuContentHtml.append(board.getName());
				sideMenuContentHtml.append("</a>");
				side_turn++;
				if (board.getBoardNum() == 2) {
					sideMenuContentHtml.append("<ul class=\"sidebar__ul\">");
					sideMenuContentHtml.append("${side-board_menu2}");
					sideMenuContentHtml.append("</ul>");
				}
			}
			boardMenuContentHtml.append("</li>");
		}

		head = head.replace("${side-board_menu}", sideMenuContentHtml.toString());

		StringBuilder sideMenuContentHtml2 = new StringBuilder();
		for (int k = 3; k < boards.size(); k++) {
			Board board = boards.get(k);
			String link = getArticleListFileName(board, 1);

			sideMenuContentHtml2.append("<li class=\"sidebar__li\">");
			sideMenuContentHtml2.append("<a href=\"" + link + "\">" + board.getName() + "</a>");
			sideMenuContentHtml2.append("</li>");

		}
		head = head.replace("${side-board_menu2}", sideMenuContentHtml2.toString());

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
			sb.insert(0, article.getTitle() + " | ");
		}
		return sb.toString();
	}

	private String getTitleBarContentByFileName(String pageName) {

		return "";
	}

	public String getArticleFileName(int num) {
		return "article_detail_" + num + ".html";
	}
}
