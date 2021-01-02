package textboard;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import textboard.Container.Container;
import textboard.Util.exportUtil;

public class testRunner {
	
	public void run() {
		
		
		
	}
	private Object testRunner() {
		// TODO Auto-generated method stub
		return null;
	}

	private void textjackson() {
		String jsonString = "{\"age\": 22, \"name\": \"홍길동\"}";
		
		ObjectMapper ob = new ObjectMapper();
		
		Map rs = null;
		try {
			rs = ob.readValue(jsonString, Map.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.println(rs.get("age"));
	}

	private void textapi() {
		String url = "https://disqus.com/api/3.0/forums/listThreads.json";
		String rs = exportUtil.callApi(url, "api_key=" + Container.config.getDisqusApiKey(), "forum = baobab612", "thread:ident=");
		
		System.out.println(rs);
	}
}
