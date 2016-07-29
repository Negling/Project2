package ua.kiral.project2.parse;

import java.util.List;
import java.util.regex.Pattern;

import ua.kiral.project2.text.Sentence;

public interface Parser {
	/**
	 * Pattern to divide sentence to sentence parts(words and characters).
	 */
	Pattern PARTS_PATTERN = Pattern.compile("([А-Яа-яA-Za-z0-9]+)|([^А-Яа-яA-Za-z]{1})");
	/**
	 * Pattern to match, that start of the string is consonant.
	 */
	Pattern CONSONANT_LETTER_PATTERN = Pattern.compile("[^АЕЁИОУЫЭЮЯІЇЄAEIOYUаеёиоуыэюяіїєaeioyu].+");
	/**
	 * Pattern to divide text to sentences(Start of the sentence is none from
	 * .!? and ends with any of .!?).
	 */
	Pattern SENTENCE_PATTERN = Pattern.compile("([^.!?]+[.!?]+)");

	/**
	 * Returns a list of sentences due to inserted text-string. Every sentence
	 * is a list of sentence-parts.
	 * 
	 * @param rawText
	 * @return
	 */
	List<Sentence> parseText(String rawText);
}
