package com.ehi.config;

import java.awt.List;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public class json {

	public json() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonStr = "{\"hasError\":false,\"status\":\"1\",\"message\":\"OK\",\"matchCount\":3,\"providers\":[{\"id\":\"14417857\",\"firstName\":\"David\",\"lastName\":\"Hines\"},{\"id\":\"12734254\",\"firstName\":\"David\",\"lastName\":\"Hines\"},{\"id\":\"13602691\",\"firstName\":\"David\",\"lastName\":\"Hines\"}]}";
		System.out.println(jsonStr);
		try {
			JSONObject jsonObject = new JSONObject(jsonStr);
			JSONArray jsonArray = jsonObject.getJSONArray("providers");
			Set<Long> list = new HashSet();
			for (int i = 0; i < jsonArray.length(); i++) {
				Long id = jsonArray.getJSONObject(i).getLong("id");
				list.add(id);
			}
			Long a=100L;
			ArrayList myList = new ArrayList();
			myList.add(100);
			System.out.print(myList.toString());
			String result = "";
			if (list.toString().length() > 2) {
				result = list.toString().substring(1, list.toString().length() - 1);
			}
			if (result.length() > 3) {
				FileOutputStream out = new FileOutputStream("D:/quote/ids.txt", true);
				out.write(result.getBytes());
				out.write(System.getProperty("line.separator").getBytes());
				out.flush();
			}
		} catch (Exception e) {

		}

	}

}
