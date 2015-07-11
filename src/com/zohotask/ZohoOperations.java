package com.zohotask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class ZohoOperations {
	private String authtoken;
	private String organization_id;

	public ZohoOperations(){	
		authtoken = "ab8fb22b25aa0bd47641c29a41783f3f";
		organization_id="55231795";
	}


	private String listitems() throws IOException{
		String url = "https://books.zoho.com/api/v3/items?authtoken="
				.concat(authtoken).concat("&organization_id=").concat(organization_id);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 		con.setRequestMethod("GET");
		
 		/*int responseCode = con.getResponseCode();
 		
 		if(responseCode !=200){
 			return null;
 			
 		}*/
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
 
		
		return response.toString();
	}



public Vector<Item> getitems() throws JSONException, IOException{
	String itemsjson = this.listitems();
	 
	JSONObject obj = new JSONObject(itemsjson);
	JSONArray arr = obj.getJSONArray("items");
	Vector<Item>items = new Vector<Item>();
	for (int i = 0; i < arr.length(); i++)
	 {
		items.add(new Item( arr.getJSONObject(i).getString("name"),arr.getJSONObject(i).getInt("purchase_rate")));
	 
	
	 
	 }
	return items;
	
	
	
}

}
