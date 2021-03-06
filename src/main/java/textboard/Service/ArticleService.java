package textboard.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import textboard.Container.Container;
import textboard.Dao.ArticleDao;
import textboard.Dto.Article;
import textboard.Dto.Board;
import textboard.Dto.Reply;

public class ArticleService {

	ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	public int delete(int i) {
		return articleDao.delete(i);
	}

	public Article getArticle(int inputedId) {
		return articleDao.getArticle(inputedId);
	}

	public int write(int memberNum, int selectBoardNum, String head, String body) {
		return articleDao.write(memberNum, selectBoardNum, head, body);
	}

	public int modify(int inputedId, String head, String body) {
		
		Map<String, Object> modifyArgs = new HashMap<>();
		
		modifyArgs.put("Num",inputedId);
		modifyArgs.put("head",head);
		modifyArgs.put("body",body);
		
		return modify(modifyArgs);
	}

	public int addBoard(int loginId, String name, String code) {
		return articleDao.addBoard(loginId, name, code);
	}

	public List<Board> getBoards() {
		return articleDao.getBoards();
	}

	public int writeReply(String name, int num, String body) {
		return articleDao.writeReply(name, num, body);
	}

	public List<Article> showList() {
		return articleDao.showList();
	}

	public List<Reply> getReplies() {
		return articleDao.getReplies();
	}

	public int addViews(int inputedId) {
		return articleDao.addViews(inputedId);
	}

	public int recommand(int loginId, int inputedId) {
		return articleDao.recommand(loginId, inputedId);

	}

	public int cancelRecommand(int loginId, int inputedId) {
		return articleDao.cancelRecommand(loginId, inputedId);
	}

	public List<Article> getArticles(int boardNum) {
		return articleDao.getArticles(boardNum);
	}

	public int modify(Map<String, Object> args) {
		return articleDao.modify(args);
	}

	public void updatePageHits() {
		articleDao.updataPageHits();
	}
}