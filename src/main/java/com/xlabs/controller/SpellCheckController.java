package com.xlabs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xlabs.config.InitLoader;
import com.xlabs.request.SpellCheckRequest;
import com.xlabs.response.SpellCheckResponse;
import com.xlabs.service.SpellCheckService;
import com.xlabs.util.ApplicationUtil;

@RestController
public class SpellCheckController {

	@Autowired
	private SpellCheckService spellCheckService;

	@Autowired
	InitLoader initLoader;

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SpellCheckResponse> filterText(HttpServletRequest request, @RequestBody String inputjson) {
		SpellCheckRequest spellingRequest = ApplicationUtil.convertJsonToObject(inputjson, SpellCheckRequest.class);
		SpellCheckResponse spellingResponse = spellCheckService.checkSpelling(spellingRequest.getWord());
		return new ResponseEntity<SpellCheckResponse>(spellingResponse, spellingResponse.getStatus());
	}

	@RequestMapping(value = "/reload", method = RequestMethod.GET)
	public void reloadDictionary() {
		initLoader.loadDictionary();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "running";
	}

}
