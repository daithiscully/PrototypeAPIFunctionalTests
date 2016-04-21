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

	String username;
    final String PROTOTYPE_URL= "http://localhost:3000/api";
	
	@Test
	public void excuteGetName() throws IOException {
        System.out.println("Started test: executeGetName()");
		JSONParser parser = new JSONParser();
		 
        try {
        	StringBuilder result = new StringBuilder();
    		URL url = new URL(PROTOTYPE_URL + "/username/1");
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
            username = name.replaceAll("\\s+","");
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finished test: executeGetName()");
	}
	
	@Test(dependsOnMethods={ "excuteGetName" })
	public void excuteGetEmailFromName() throws IOException {

        System.out.println("Started test: excuteGetEmailFromName()\nName checking: " + username);
		JSONParser parser = new JSONParser();
		 
        try {
        	StringBuilder result = new StringBuilder();
    		URL url = new URL(PROTOTYPE_URL + "/useremail/" + username);
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

            String email = (String) jsonObject.get("email");

            System.out.println("email: " + email);
            //Assert.assertTrue(email.equals("PinkFloyd@gmail.com"));
            Assert.assertTrue(email.equals("NoEmailGiven@gmail.com"));
 
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finished test: excuteGetEmailFromName()");
	}
}
