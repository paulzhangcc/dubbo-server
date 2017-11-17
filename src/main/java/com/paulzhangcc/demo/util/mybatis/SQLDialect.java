package com.paulzhangcc.demo.util.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLDialect {

	/**
	 * @SelectKey(before = SQLDialect.SelectKey.before, resultType = Integer.class, keyProperty = "loanId", statement = { SQLDialect.SelectKey.LOAN })
	 */
	public static class SelectKey {
		public static final boolean before = true;
		public static final boolean after = false;
		public static final String S_DEMO = "SELECT s_demo.nextval FROM dual";
	}

	private static final Logger logger = LoggerFactory.getLogger(SQLDialect.class);

	private static final ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();

	// 分页limit
	private static final Pattern RE_LIMIT = Pattern.compile(

			"^(.+)limit\\s+\\?\\s*(,\\s*\\?)?\\s*$",

			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	// Top n
	private static final Pattern RE_LIMIT2 = Pattern.compile(

			"^(.+)limit\\s+(\\d+)\\s*$",

			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	private static final Pattern FOR_UPDATE = Pattern.compile(

			"^(.+)for\\s+update$",

			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	public static String parse(String sql) {
		sql = sql.trim().toLowerCase();
		Matcher m = FOR_UPDATE.matcher(sql);
		if (m.find()){
			logger.warn("sql中禁止用for update,传入sql为【{}】",sql);
			throw new IllegalArgumentException("sql禁止用for update");
		}
		String newsql = CACHE.get(sql);
		CACHE.clear();
		if (newsql == null) {
			newsql = filterLimit(sql);
			newsql = newsql.replaceAll(";\\s*$", "");
			newsql = newsql.replaceAll("`", "");
			CACHE.put(sql, newsql);
		}

		return newsql;
	}

	private static String filterLimit(String sql) {
		Matcher m = RE_LIMIT.matcher(sql);
		if (m.find()) {
			String target = m.group(1);
			if (logger.isDebugEnabled()) {
				logger.debug(target);
			}

			return getLimitString(target, m.group(2) != null);
		}

		m = RE_LIMIT2.matcher(sql);
		if (m.find()) {
			String target = m.group(1);
			if (logger.isDebugEnabled()) {
				logger.debug(target);
			}

			return getLimitString(target, m.group(2));
		}

		return sql;
	}

	private static String getLimitString(String sql, boolean hasOffset) {
		StringBuffer sb = new StringBuffer(sql.length() + 100);
		if (hasOffset) {
			sb.append("SELECT * FROM ( SELECT row_.*, rownum AS rownum_ FROM ( ");
		} else {
			sb.append("SELECT * FROM ( ");
		}
		sb.append(sql);
		if (hasOffset) {
			sb.append(" ) row_ ) WHERE rownum_ > ? and  rownum_ <= ?");
		} else {
			sb.append(" ) WHERE rownum <= ?");
		}

		return sb.toString();
	}

	private static String getLimitString(String sql, String limit) {
		StringBuffer sb = new StringBuffer(sql.length() + 100);
		sb.append("SELECT * FROM ( ");
		sb.append(sql);
		sb.append(" ) WHERE rownum <= ");
		sb.append(limit);
		return sb.toString();
	}
}
