package com.liferay.geolocation.bulk.util;

public class GeolocationDemoDatasetBulkLoader {

	public void load(int limit, boolean dryRun) throws Exception {
		GeolocationDemoDataset dataset = new Parser_311_requests_json().parse();

		new JournalArticleBulkLoader(dataset, limit, dryRun).load();
	}

}
