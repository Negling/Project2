package com.epam.kiral.project2.parse;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

import com.epam.kiral.project2.text.Char;
import com.epam.kiral.project2.text.Sentence;
import com.epam.kiral.project2.text.SentencePart;
import com.epam.kiral.project2.text.Word;
import com.epam.kiral.project2.text.SentencePart.Type;

/**
 * This is an util class, required to parse raw text into list of sentences, and
 * sentence parts.
 * 
 * @author Nazarii Kiral
 *
 */
public class SimpleTextParser implements Parser {

	@Override
	public List<Sentence> parseText(String rawText) {
		// Replacing from text all tab signs and double-spaces
		String clearText = rawText.replaceAll("(\t+)|( {2,})", " ");
		List<Sentence> sentences = new LinkedList<>();
		Matcher matcher = SENTENCE_PATTERN.matcher(clearText);
		while (matcher.find()) {
			sentences.add(new Sentence(parseSentence(matcher.group())));
		}
		if (matcher.regionEnd() != clearText.length()) {
			sentences.add(new Sentence(parseSentence(clearText.substring(matcher.regionEnd()))));
		}
		return sentences;
	}

	/**
	 * Returns list of text, splitted to sentence-parts.
	 * 
	 * @param sentence
	 * @return
	 */
	protected List<SentencePart> parseSentence(String sentence) {
		List<SentencePart> sent = new LinkedList<>();
		Matcher matcher = PARTS_PATTERN.matcher(sentence);
		while (matcher.find()) {
			if (matcher.group().matches("\\p{Punct}")) {
				sent.add(new Char(matcher.group().charAt(0), Type.PUNCTUATION));
			} else if (matcher.group().matches("[^А-Яа-яA-Za-z]{1}")) {
				sent.add(new Char(matcher.group().charAt(0), Type.CHAR));
			} else {
				sent.add(new Word(matcher.group()));
			}
		}
		return sent;
	}
}