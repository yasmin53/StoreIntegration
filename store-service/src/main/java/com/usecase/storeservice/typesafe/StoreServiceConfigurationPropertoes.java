package com.usecase.storeservice.typesafe;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my")
public class StoreServiceConfigurationPropertoes {

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
