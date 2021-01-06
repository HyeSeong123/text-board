package textboard;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.DateRange;
import com.google.analytics.data.v1alpha.Dimension;
import com.google.analytics.data.v1alpha.Entity;
import com.google.analytics.data.v1alpha.Metric;
import com.google.analytics.data.v1alpha.Row;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;

import textboard.Container.Container;
import textboard.Util.MysqlUtil;
import textboard.Util.exportUtil;

public class testRunner {

	public void run() {
		MysqlUtil.setDBInfo(Container.config.getDbHost(), Container.config.getDbId(), Container.config.getDbPw(), "a1");
		testGoogleCredentials();
		textUpdateGoogleAnalyticeApi();
		testUpdatePageHits();
		MysqlUtil.closeConnection();
	}

	private void testUpdatePageHits() {
		Container.googleAnalyticsApiService.updateHitsApiData();
		
	}

	private void textUpdateGoogleAnalyticeApi() {
		String ga4PropertyId = Container.config.getGa4PropertyId();
		try (AlphaAnalyticsDataClient analyticsData = AlphaAnalyticsDataClient.create()) {
			RunReportRequest request = RunReportRequest.newBuilder()
					.setEntity(Entity.newBuilder().setPropertyId(ga4PropertyId))
					.addDimensions(Dimension.newBuilder().setName("pagePath"))
					.addMetrics(Metric.newBuilder().setName("activeUsers"))
					.addDateRanges(DateRange.newBuilder().setStartDate("2020-01-01").setEndDate("today")).build();

			// Make the request
			RunReportResponse response = analyticsData.runReport(request);

			System.out.println("Report result:");
			for (Row row : response.getRowsList()) {
				System.out.printf("%s, %s%n",  row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void testGoogleCredentials() {
		String keyFilePath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");

		System.out.println(keyFilePath);

	}

	private Object testRunner() {
		// TODO Auto-generated method stub
		return null;
	}

	private void textjackson() {
		String jsonString = "{\"age\": 22, \"name\": \"홍길동\"}";

		ObjectMapper ob = new ObjectMapper();

		Map rs = null;
		try {
			rs = ob.readValue(jsonString, Map.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.println(rs.get("age"));
	}

	private void textapi() {
		String url = "https://disqus.com/api/3.0/forums/listThreads.json";
		String rs = exportUtil.callApi(url, "api_key=" + Container.config.getDisqusApiKey(), "forum = baobab612",
				"thread:ident=");

		System.out.println(rs);
	}
}
