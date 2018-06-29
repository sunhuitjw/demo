package com.greyson.gycptest.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import com.greyson.gycptest.util.LogUtil;

public class DynamicDataSource extends AbstractRoutingDataSource{
	public static final Map<DatabaseType, List<String>> METHOD_TYPE_MAP = new HashMap<>();
	
	@Nullable
	@Override
	protected Object determineCurrentLookupKey() {
		DatabaseType type = DatabaseContextHolder.getDatabaseType();
        LogUtil.info("====================dataSource ==========" + type);
        return type;
	}
	
	void setMethodType(DatabaseType type, String content) {
        List<String> list = Arrays.asList(content.split(","));
        METHOD_TYPE_MAP.put(type, list);
    }

}
