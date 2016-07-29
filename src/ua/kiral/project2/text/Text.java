package ua.kiral.project2.text;

import java.util.Iterator;
import java.util.List;

import ua.kiral.project2.parse.Parser;

public class Text {
	private List<Sentence> sentences;

	private Text(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	/**
	 * Creates an instance of Text class, initialized with inserted string type.
	 * 
	 * @param rawText
	 * @return
	 */
	public static Text initialize(String rawText, Parser textParser) {
		return new Text(textParser.parseText(rawText));
	}

	@Override
	public String toString() {
		Iterator<Sentence> it = sentences.iterator();
		if (!it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		while (true) {
			Sentence e = it.next();
			sb.append(e == sentences ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.toString();
		}
	}

	/**
	 * Removes all words from the text, which match to the next conditions: 1)
	 * First letter of word is consonant. 2) Word length equals to given value.
	 * 
	 * @param wordLength
	 */
	public void removeWords(int wordLength) {
		Iterator<Sentence> textIterator = sentences.listIterator();
		while (textIterator.hasNext()) {
			Iterator<SentencePart> sentcItertor = textIterator.next().getContent().listIterator();
			while (sentcItertor.hasNext()) {
				SentencePart currentValue = sentcItertor.next();
				if(currentValue.getClass().equals(Word.class)){
					String word = ((Word) currentValue).getContent();
					if (word.length() == wordLength && word.matches(Parser.CONSONANT_LETTER_PATTERN.pattern())) {
						sentcItertor.remove();
					}
				}
			}
		}
	}
}