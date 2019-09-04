package com.dictionary;


import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WelcomeController {

	// inject via application.properties
	String fileMessage = null;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadFile(Map<String, Object> model,
			@RequestParam("getFileName") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				fileMessage = new String(file.getBytes());
				String status = DatabaseOperations.createItems(fileMessage);
				System.out.println("file status --> " + status);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search";
		}
		return "welcome";
	}

	@RequestMapping(value = "/searchWord", method = RequestMethod.POST)
	public String searchWord(Map<String, Object> model,
			@RequestParam("searchText") String searchText) {
		if (!searchText.isEmpty())
			model.put("searchResult",
					DatabaseOperations.searchItems(searchText.toLowerCase()));
		return "search";
	}
}