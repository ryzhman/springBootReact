package com.go2it.edu.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author Alex Ryzhkov
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Override
	public String getUserById(String employeeId) {
		try {
			StringBuilder result = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("");
			HttpResponse response = null;
			response = client.execute(request);

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getUsers() {
		try {
			StringBuilder result = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://dummy.restapiexample.com/api/v1/employees");
			HttpResponse response = null;
			response = client.execute(request);

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return new JSONObject().put("employees", result.toString()).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String createNewEmployee(String body) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://vogellac2dm.appspot.com/register");
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("registrationid", "123456789"));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}

			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String updateEmployee(String employeeId) {
		return null;
	}

	@Override
	public String deleteEmployee(String employeeId) {
		return null;
	}
}
