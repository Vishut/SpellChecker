package com.xlabs.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.springframework.http.HttpStatus;

public class SpellCheckResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7398650756839233910L;
	private Set<String> relevantWords = Collections.emptySet();
	private HttpStatus status;

	public Set<String> getRelevantWords() {
		return relevantWords;
	}

	public void setRelevantWords(Set<String> relevantWords) {
		this.relevantWords = relevantWords;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
