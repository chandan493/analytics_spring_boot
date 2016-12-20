package com.custom.model;

import java.io.Serializable;

public class CustomStatistics implements Serializable {

	private String key;
	private Long count;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
