package com.xlabs.service;

import com.xlabs.response.SpellCheckResponse;

public interface SpellCheckService {

	public SpellCheckResponse checkSpelling(String word);
}
