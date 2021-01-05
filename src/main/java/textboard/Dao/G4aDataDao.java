package textboard.Dao;

import textboard.Util.MysqlUtil;
import textboard.Util.SecSql;

public class G4aDataDao {

	public void update(String pagePath, int hit) {
		
	}

	public int deletePagePath(String pagePath) {
		SecSql sql = new SecSql();
		sql.append("DELETE");
		sql.append("FROM ga4DataPageHit");
		sql.append("WHERE pagePath =?", pagePath);
		
		return MysqlUtil.delete(sql);
	}

	public int updatePagePath(String pagePath, int hit) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO ga4DataPageHit");
		sql.append("Set regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("pagePath = ?,",pagePath);
		sql.append("hit = ?",hit);

		return MysqlUtil.insert(sql);
	}

}
