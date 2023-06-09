package com.ssafy.home.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;


public class NaverSearch {
	// naver api key
    private static String client_id = "E25Zs5wh2ZuibSnoG_BH";
    private static String client_secret = "OuVYR4TdMo";

    //[CODE 1]
    private static String getRequestUrl(String url) {
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", client_id);
            con.setRequestProperty("X-Naver-Client-Secret", client_secret);
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                System.out.println("[" + new Date() + "] Url Request Success");
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("[" + new Date() + "] Error for URL : " + url);
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("[" + new Date() + "] Error for URL : " + url);
            return null;
        }
    }

    //[CODE 2]
    private static JSONObject getNaverSearch(String node, String srcText, int start, int display) {
        String base = "https://openapi.naver.com/v1/search";
        node = "/" + node + ".json";
        @SuppressWarnings("deprecation")
		String parameters = "?query=" + URLEncoder.encode(srcText) + "&start=" + start + "&display=" + display;

        String url = base + node + parameters;
        String responseDecode = getRequestUrl(url); //[CODE 1]

        if (responseDecode == null) {
            return null;
        } else {
            return new JSONObject(responseDecode);
        }
    }

    //[CODE 3]
    private static void getPostData(JSONObject post, JSONArray jsonResult, int cnt) {
        String title = post.getString("title");
        String description = post.getString("description");
        String org_link = post.getString("originallink");
        String link = post.getString("link");

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pDate;
        try {
            pDate = inputDateFormat.parse(post.getString("pubDate"));
            String pDateString = outputDateFormat.format(pDate);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cnt", cnt);
            jsonObject.put("title", title);
            jsonObject.put("description", description);
            jsonObject.put("org_link", org_link);
            jsonObject.put("link", link);
            jsonObject.put("pDate", pDateString);
            jsonResult.put(jsonObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }
    
    public static JSONArray jsonSave() {
    	int cnt = 0;
    	String node = "news";
    	String text = "부동산";
    	
    	JSONArray jsonResult = new JSONArray();
    	
    	JSONObject jsonResponse = getNaverSearch(node, text, 1, 100); // [CODE 2]
    	
    	while (jsonResponse != null && jsonResponse.getInt("display") != 0) {
            JSONArray items = jsonResponse.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONObject post = items.getJSONObject(i);
                cnt++;
                // jsonarray 저장
                getPostData(post, jsonResult, cnt); // [CODE 3]
            }

            int start = jsonResponse.getInt("start") + jsonResponse.getInt("display");
            
            jsonResponse = getNaverSearch(node, text, start, 100); // [CODE 2]
            
            if(cnt == 100) break; // 종
        }
        return jsonResult;
    }
}