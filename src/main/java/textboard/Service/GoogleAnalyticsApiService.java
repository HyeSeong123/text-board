package textboard.Service;

import java.io.IOException;

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.DateRange;
import com.google.analytics.data.v1alpha.Dimension;
import com.google.analytics.data.v1alpha.Entity;
import com.google.analytics.data.v1alpha.Metric;
import com.google.analytics.data.v1alpha.Row;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;

import textboard.Container.Container;
import textboard.Dao.G4aDataDao;


public class GoogleAnalyticsApiService {
	private G4aDataDao ga4DataDao;
	
	public GoogleAnalyticsApiService() {
		ga4DataDao = new G4aDataDao(); 
	}
	
	public boolean updateHitsApiData() {
		
		String ga4PropertyId = Container.config.getGa4PropertyId();
		try (AlphaAnalyticsDataClient analyticsData = AlphaAnalyticsDataClient.create()) {
			RunReportRequest request = RunReportRequest.newBuilder()
					.setEntity(Entity.newBuilder().setPropertyId(ga4PropertyId))
					.addDimensions(Dimension.newBuilder().setName("pagePath"))
					.addMetrics(Metric.newBuilder().setName("activeUsers"))
					.addDateRanges(DateRange.newBuilder().setStartDate("2020-01-04").setEndDate("today")).build();

			// Make the request
			RunReportResponse response = analyticsData.runReport(request);

			System.out.println("Report result:");
			for (Row row : response.getRowsList()) {
				String pagePath =  row.getDimensionValues(0).getValue();
				int hit = Integer.parseInt(row.getMetricValues(0).getValue());
				
				System.out.printf("pagePath : %s, hit : %d\n",pagePath , hit);
				
				update(pagePath,hit);
			}
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	private void update(String pagePath, int hit) {
		ga4DataDao.deletePagePath(pagePath);
		ga4DataDao.updatePagePath(pagePath,hit);
	}

}
