package com.hzframework.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by paul on 15-3-25.
 */
public class HttpHelper {
	public static String doGet(String url) throws IOException {
		HashMap map = new HashMap();
		return doPost(url, map);
	}

	public static String doGet(String url, Map<String, String> params)
			throws IOException {
		String content = "";
		if (params != null && params.size() > 0) {
			StringBuilder sb = new StringBuilder();

			for (String key : params.keySet()) {
				sb.append(key + "=" + params.get(key));
				sb.append("&");
			}
			content = sb.toString(); // "&activatecode=" +
										// URLEncoder.encode("汉字", "utf-8");
		}

		String getURL = StringHelper.trimEnd(url, "?") + content;
		URL getUrl = new URL(getURL);

		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();

		connection.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码

		String line;
		StringBuilder stringBuilder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}
		reader.close();

		connection.disconnect();
		return stringBuilder.toString();
	}

	public static String getPostParams(Map<String, String> params) {
		if (params == null || params.size() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();

		for (String key : params.keySet()) {
			sb.append(key + "=" + params.get(key));
			sb.append("&");
		}
		String content = sb.toString(); // "&activatecode=" +
										// URLEncoder.encode("汉字", "utf-8");
		return StringHelper.trimEnd(content, "&");
	}

	public static String doPost(String url) throws IOException {
		return doPost(url, "");
	}

	public static String doPost(String url, String params) throws IOException {
		URL postUrl = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		// Output to the connection. Default is
		// false, set to true because post
		// method must write something to the
		// connection
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// Set the post method. Default is GET
		connection.setRequestMethod("POST");
		// Post cannot use caches
		connection.setUseCaches(false);
		// This method takes effects to
		// every instances of this class.
		// connection.setFollowRedirects(true);

		// This methods only
		// takes effacts to this
		// instance.
		connection.setInstanceFollowRedirects(true);
		// Set the content type to urlencoded,
		// because we will write
		// some URL-encoded content to the
		// connection. Settings above must be set before connect!
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		// The URL-encoded contend

		if (!StringHelper.isNullOrEmpty(params))
			out.writeBytes(params);

		out.flush();
		out.close(); // flush and close
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
		String line = "";

		StringBuilder stringBuilder = new StringBuilder();
		while ((line = reader.readLine()) != null) {

			stringBuilder.append(line);
		}

		reader.close();
		connection.disconnect();

		return stringBuilder.toString();
	}

	public static String doPost(String url, Map<String, String> params)
			throws IOException {

		String content = getPostParams(params);

		return doPost(url, content);

	}
}
