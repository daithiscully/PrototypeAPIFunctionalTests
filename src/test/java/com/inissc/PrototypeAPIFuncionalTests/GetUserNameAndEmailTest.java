package com.inissc.PrototypeAPIFuncionalTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class GetUserNameAndEmailTest {

	@Test
	public void excuteGet() throws IOException {
		StringBuilder result = new StringBuilder();
		URL url = new URL("http://localhost:3000/api/user/1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		System.out.println("Result: " + result);
		// Assert.assertTrue(result.);
	}
}
