package com.liferay.geolocation.bulk.command;

import com.liferay.geolocation.bulk.util.GeolocationDemoDatasetBulkLoader;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate=true,
	service = Object.class,
	property = {
		"osgi.command.function=load",
		"osgi.command.scope=geolocation"
	}
)
public class GeolocationBulkLoadCommand {

	public void load(String limit) throws Exception {
		boolean dryRun = false;
		new GeolocationDemoDatasetBulkLoader().load(Integer.valueOf(limit), dryRun);
	}

	public void load() throws Exception {
		load("10");
	}

	@Activate
	protected void start() {
		System.out.println("Geolocation Bulk Load is ready...");
	} 
}