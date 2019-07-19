package com.xlabs.request;

import org.springframework.stereotype.Component;

@Component
public class SpellCheckRequest {

	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
