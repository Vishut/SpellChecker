package com.xlabs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xlabs.config.InitLoader;
import com.xlabs.response.SpellCheckResponse;

@Service
public class SpellCheckServiceImpl implements SpellCheckService {

	public static TreeSet<String> relevantWords = new TreeSet<>();

	@Override
	public SpellCheckResponse checkSpelling(String word) {
		SpellCheckResponse response = new SpellCheckResponse();

		try {

			if (InitLoader.dictionary.contains(word)) {
				relevantWords.add(word);
				response.setRelevantWords(relevantWords);
			}

			List<String> wordsList = getWords(word);
			// check if returned words list exists in our dictionary
			for (String s : wordsList) {
				if (InitLoader.dictionary.contains(s)) {
					relevantWords.add(s);
				}
			}

			response.setRelevantWords(relevantWords);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {

		}
		return response;
	}

	public static List<String> getWords(String word) {

		List<String> list = new ArrayList<String>();

		String str = null;

		// remove every char one by one
		for (int i = 0; i < word.length(); i++) {
			str = word.substring(0, i) + word.substring(i + 1);
			list.add(str);
		}

		// swap every char with adjacent
		for (int i = 0; i < word.length() - 1; i++) {
			str = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2);
			list.add(str);
		}

		// replace every char with a-z
		for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				str = word.substring(0, i) + c + word.substring(i + 1);
				list.add(str);
			}
		}

		// add char from a-z at all indexes
		for (int i = 0; i <= word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				str = word.substring(0, i) + c + word.substring(i);
				list.add(str);
			}
		}
		
		System.out.println("List of words : " + list);

		return list;
	}

}
