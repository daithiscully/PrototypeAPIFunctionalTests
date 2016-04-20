package com.inissc.PrototypeAPIFuncionalTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserNameAndEmailTest {

	/*@Test
	public void excuteGetName() throws IOException {
		StringBuilder result = new StringBuilder();
		URL url = new URL("http://localhost:3000/api/username/1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		System.out.println("Result: " + result);

		
		Assert.assertTrue(result.equals("{\"id\":\"1\",\"name\":\"Pink Floyd\"}"));
	}*/
	
	@Test
	public void excuteGetName() throws IOException {
		JSONParser parser = new JSONParser();
		 
        try {
        	StringBuilder result = new StringBuilder();
    		URL url = new URL("http://localhost:3000/api/username/1");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {
    			result.append(line);
    		}
    		rd.close();
            Object obj = parser.parse(result.toString());
 
            JSONObject jsonObject = (JSONObject) obj;

            String id = (String) jsonObject.get("id");
            String name = (String) jsonObject.get("name");

            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            Assert.assertTrue(name.equals("Pink Floyd"));
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
