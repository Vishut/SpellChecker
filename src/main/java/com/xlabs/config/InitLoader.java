package com.xlabs.config;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/*
 * 
 */
@Component
public class InitLoader {

	public static HashSet<String> dictionary = new HashSet<>();

	@PostConstruct
	private void init() {
		loadDictionary();
	}

	/*
	 * load from file or from database or any other source, here we are loading from
	 * txt file
	 */
	public void loadDictionary() {
		try (Stream<String> stream = Files
				.lines(Paths.get(getClass().getClassLoader().getResource("dictionary.txt").toURI()))) {
			dictionary = (HashSet<String>) stream.map(String::toLowerCase).collect(Collectors.toSet());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
