package textboard.Service;

import java.util.HashMap;
import java.util.Map;

import textboard.Container.Container;
import textboard.Dto.Article;
import textboard.Dto.DisqusApiDataListThread;
import textboard.Util.exportUtil;

public class DisqusService {

	public Map<String, Object> getArticleData(Article article) {
		String fileName = Container.exportService.getArticleFileName(article.num);
		String url = "https://disqus.com/api/3.0/forums/listThreads.json";

		DisqusApiDataListThread disqusApiDataListThread = (DisqusApiDataListThread) exportUtil.callApiResponseTo(
				DisqusApiDataListThread.class, url, "api_key=" + Container.config.getDisqusApiKey(),
				"forum=" + Container.config.getSiteName(), "thread:ident=" + fileName);

		if (disqusApiDataListThread == null) {
			return null;
		}
		
		Map<String, Object> rs = new HashMap<>();
		rs.put("likes", disqusApiDataListThread.response.get(0).likes);
		rs.put("commentsCount", disqusApiDataListThread.response.get(0).posts);
		return rs;

	}

}
