package textboard.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import textboard.Dto.Article;
import textboard.Dto.Board;
import textboard.Dto.Reply;
import textboard.Util.MysqlUtil;
import textboard.Util.SecSql;

public class ArticleDao {

	public List<Article> showList() {
		List<Article> Lists = new ArrayList<Article>();

		SecSql sql = new SecSql();

		sql.append("SELECT article.*, Member.name AS extra__writer, board.name AS extra__board");
		sql.append("FROM article");
		sql.append("INNER JOIN Member");
		sql.append("ON article.memberNum = Member.memberNum");
		sql.append("INNER JOIN board");
		sql.append("ON article.boardNum = board.boardNum");
		sql.append("ORDER BY article.num DESC");

		List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);

		for (Map<String, Object> articleMap : articleListMap) {

			Lists.add(new Article(articleMap));
		}

		return Lists;
	}

	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<Article>();
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM article");
		sql.append("ORDER BY num DESC");

		List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);

		for (Map<String, Object> articleMap : articleListMap) {

			articles.add(new Article(articleMap));
		}

		return articles;
	}

	public List<Article> getArticles(int boardId) {
		List<Article> articles = new ArrayList<Article>();
		SecSql sql = new SecSql();

		sql.append("SELECT article.*, member.name As extra__writer");
		sql.append("FROM article");
		sql.append("INNER JOIN member");
		sql.append("ON article.memberNum = member.memberNum");
		if (boardId != 0) {
			sql.append("WHERE article.boardNum = ?", boardId);
		}
		sql.append("ORDER BY num DESC");

		List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);

		for (Map<String, Object> articleMap : articleListMap) {

			articles.add(new Article(articleMap));
		}

		return articles;
	}

	public int delete(int i) {
		SecSql sql = new SecSql();
		SecSql sql1 = new SecSql();
		int k = index(i);

		if (k == -2) {
			System.out.println("존재하지 않는 게시물 입니다.");
			return -2;
		}
		sql.append("Delete FROM article");
		sql.append("WHERE num = ?", i);

		MysqlUtil.delete(sql);

		sql1.append("Delete FROM Reply");
		sql1.append("WHERE articleNum = ?", i);

		MysqlUtil.delete(sql1);

		return i;
	}

	public Article getArticle(int inputedId) {
		SecSql sql = new SecSql();
		int k = index(inputedId);

		if (k == -2) {
			System.out.println("존재하지 않는 게시물 입니다.");
			return null;
		}
		sql.append("SELECT *");
		sql.append("FROM article");
		sql.append("WHERE Num = ?", inputedId);

		Map<String, Object> articleMap = MysqlUtil.selectRow(sql);
		Article article = new Article(articleMap);

		return article;
	}

	public int write(int memberNum, int selectBoardNum, String head, String body) {
		SecSql sql = new SecSql();

		sql.append("INSERT INTO article");
		sql.append("Set memberNum = ?,", memberNum);
		sql.append("views = 0,");
		sql.append("boardNum = ?,", selectBoardNum);
		sql.append("replyNum = 0,");
		sql.append("recommandNum = 0,");
		sql.append("regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("title = ?,", head);
		sql.append("body = ?", body);

		return MysqlUtil.insert(sql);
	}

	public int modify(Map<String, Object> args) {
		SecSql sql = new SecSql();
		
		int num = (int) args.get("Num");
		String title = args.get("title") != null ? (String)args.get("title") : null;
		String body = args.get("body") != null ? (String)args.get("body") : null;
		int likes = args.get("likes") != null ? (int)args.get("likes") : -1;
		int commentsCount = args.get("commentsCount") != null ? (int)args.get("commentsCount") : -1;

		sql.append("UPDATE article");
		sql.append("SET updateDate = NOW(),");
		if (title != null) {
			sql.append("title = ?,", title);
		}
		if (body != null) {
			sql.append("body = ?,", body);
		}
		if (likes != -1) {
			sql.append("likes = ?,", likes);
		}
		if (commentsCount != -1) {
			sql.append("commentsCount = ?", commentsCount);
		}
		
		sql.append("WHERE Num = ?", num);
		
		return MysqlUtil.update(sql);
	}

	public int addBoard(int loginId, String name, String code) {
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM Member");
		sql.append("WHERE memberNum = ?", loginId);

		Map<String, Object> master = MysqlUtil.selectRow(sql);

		if (master.get("name").equals("방혜성") == false || master.get("id").equals("baobab612") == false) {
			return -1;
		}
		SecSql sql1 = new SecSql();

		sql1.append("INSERT INTO board");
		sql1.append("Set name = ?,", name);
		sql1.append("regDate = NOW(),");
		sql1.append("updateDate = NOW(),");
		sql1.append("code = ?", code);

		return MysqlUtil.insert(sql1);
	}

	public List<Board> getBoards() {
		List<Board> boards = new ArrayList<>();
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM board");

		List<Map<String, Object>> boardListMap = MysqlUtil.selectRows(sql);

		for (int i = 0; i < boardListMap.size(); i++) {
			Map<String, Object> boardMap = boardListMap.get(i);

			boards.add(new Board(boardMap));
		}
		return boards;
	}

	public int writeReply(String name, int num, String body) {
		SecSql sql = new SecSql();
		SecSql sql1 = new SecSql();
		int k = index(num);

		if (k == -2) {
			System.out.println("존재하지 않는 게시물 입니다.");
			return -2;
		}
		sql.append("UPDATE article");
		sql.append("Set replyNum = replyNum+1");
		sql.append("WHERE num = ?", num);

		MysqlUtil.update(sql);

		sql1.append("INSERT INTO reply");
		sql1.append("SET name = ?,", name);
		sql1.append("articleNum = ?,", num);
		sql1.append("regDate = NOW(),");
		sql1.append("updateDate = NOW(),");
		sql1.append("body = ?", body);

		return MysqlUtil.insert(sql1);
	}

	public List<Reply> getReplies() {
		List<Reply> replies = new ArrayList<>();
		SecSql sql = new SecSql();

		sql.append("SELECT *");
		sql.append("FROM Reply");

		List<Map<String, Object>> replyListMap = MysqlUtil.selectRows(sql);

		for (int i = 0; i < replyListMap.size(); i++) {
			Map<String, Object> replyMap = replyListMap.get(i);

			replies.add(new Reply(replyMap));
		}
		return replies;
	}

	public int addViews(int inputedId) {
		SecSql sql = new SecSql();
		int i = index(inputedId);

		if (i == -2) {
			System.out.println("존재하지 않는 게시물 입니다.");
			return -2;
		}

		sql.append("UPDATE article");
		sql.append("Set views = views+1");
		sql.append("WHERE Num = ?", inputedId);
		MysqlUtil.update(sql);

		SecSql sql1 = new SecSql();
		sql1.append("Select views");
		sql1.append("FROM article");
		sql1.append("WHERE Num = ?", inputedId);

		int k = MysqlUtil.selectRowIntValue(sql1);

		return k;
	}

	public int recommand(int loginId, int inputedId) {
		SecSql sql1 = new SecSql();

		int i = index(inputedId);

		if (i == -2) {
			return -2;
		}

		sql1.append("SELECT memberId");
		sql1.append("FROM Recommand");
		sql1.append("WHERE articleId = ?", inputedId);

		int k = MysqlUtil.selectRowIntValue(sql1);

		if (k == loginId) {
			return -1;
		}

		SecSql sql = new SecSql();

		sql.append("INSERT INTO Recommand");
		sql.append("SET regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("memberId = ?,", loginId);
		sql.append("articleId = ?", inputedId);

		SecSql sql2 = new SecSql();

		sql2.append("UPDATE article");
		sql2.append("SET recommandNum = recommandNum+1");
		sql2.append("WHERE num = ?", inputedId);

		MysqlUtil.update(sql2);

		return MysqlUtil.insert(sql);
	}

	private int index(int num) {
		List<Article> articles = getArticles();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).num == num) {
				return 1;
			}
		}

		return -2;
	}

	public int cancelRecommand(int loginId, int inputedId) {

		SecSql sql = new SecSql();

		int i = index(inputedId);

		if (i == -2) {
			return -2;
		}
		sql.append("SELECT memberId");
		sql.append("FROM Recommand");
		sql.append("WHERE articleId = ?", inputedId);

		int k = MysqlUtil.selectRowIntValue(sql);

		if (k != loginId) {
			return -1;
		}
		SecSql sql1 = new SecSql();

		sql1.append("DELETE FROM Recommand");
		sql1.append("WHERE articleId = ?", inputedId);

		MysqlUtil.delete(sql1);

		SecSql sql2 = new SecSql();

		sql2.append("UPDATE article");
		sql2.append("SET recommandNum = recommandNum-1");
		sql2.append("WHERE num = ?", inputedId);

		MysqlUtil.update(sql2);

		return 1;
	}

	public void updataPageHits() {
		SecSql sql = new SecSql();
		
		sql.append("UPDATE article as AR");
		sql.append("INNER JOIN (");
		sql.append("	SELECT CASE(REPLACE(REPLACE(ga4_PP.pagePathWoQueryStr, '/',''),'.html','')AS UNSIGNED) AS articleNum,");
		sql.append("	hit");
		sql.append("	FROM(");
		sql.append("	SELECT");
		sql.append("	IF(");
		sql.append("	INSTR(ga4_PP.pagePath, '?') = 0,");
		sql.append("	ga4_PP.pagePath,");
		sql.append("	SUBSTR(ga4_PP.pagePath, 1, INSTR(ga4_PP.pagePath, '?')-1)");
		sql.append("	) AS pagePathWoQueryStr,");
		sql.append("	SUM(ga4_PP.hit) AS hit");
		sql.append("	FROM ga4DataPageHit AS ga4_PP");
		sql.append("	WHERE ga4_PP.pagePath LIKE '/%.html%'");
		sql.append("	GROUP BY pagePathWoQueryStr");
		sql.append("	)AS ga4_PP");
		sql.append("  )AS ga4_PP");
		sql.append("ON AR.Num = ga4_PP.articleNum");
		sql.append("SET AR.views = ga4_PP.hit");
		

	}
}
