package textboard.Container;

import java.util.Scanner;

import textboard.Controller.ArticleController;
import textboard.Controller.ExportController;
import textboard.Controller.MemberController;
import textboard.Dao.ArticleDao;
import textboard.Dao.MemberDao;
import textboard.Service.ArticleService;
import textboard.Service.ExportService;
import textboard.Service.MemberService;
import textboard.Session.Session;

public class Container {

	public static Scanner sc;
	public static Session session;
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;
	public static ExportService exportService;
	public static ArticleController articleController;
	public static MemberController memberController;
	public static ExportController exportController;

	static {
		sc = new Scanner(System.in);
		session = new Session();
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
		memberService = new MemberService();
		exportService = new ExportService();
		articleController = new ArticleController();
		memberController = new MemberController();
		exportController = new ExportController();
	}
}
