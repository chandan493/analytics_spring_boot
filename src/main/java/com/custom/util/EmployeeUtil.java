package com.custom.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.custom.model.CustomStatistics;

public class EmployeeUtil {
	public static Map<String, Long> percentageCalculator(
			List<CustomStatistics> empListFromRecord) {
		Map<String, Long> finalStat = new HashMap<String, Long>();
		int recordCount = empListFromRecord.size();
		for (CustomStatistics c : empListFromRecord) {
			long stat = (c.getCount() / recordCount) * 100;
			finalStat.put(c.getKey(), stat);
		}
		return finalStat;
	}
}
