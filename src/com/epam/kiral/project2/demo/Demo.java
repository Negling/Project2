package com.epam.kiral.project2.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.epam.kiral.project2.parse.SimpleTextParser;
import com.epam.kiral.project2.text.Text;

/**
 * Simple class-demonstration. It's Alive!
 * 
 * @author Kael
 *
 */
public class Demo {
	public static void main(String... args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("Collections.txt"))) {
			// 1) Reading text file Collections.txt and initializing out Text.class exemplar with it.
			Text txt = Text.initialize(reader.readLine(), new SimpleTextParser());
			// 2) Looking what we got.
			System.out.println(txt);
			// 3) Removing all words from text, which have length = 5, and starts with consonant letter.
			txt.removeWords(5);
			// 4) Checking results.
			System.out.println(txt);
			// 5) Being proud.
		} catch (IOException ignore) {
		}
	}
}
