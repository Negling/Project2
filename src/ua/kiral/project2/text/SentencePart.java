package ua.kiral.project2.text;
public interface SentencePart {
	enum Type {
		WORD, CHAR, PUNCTUATION
	}
	/**
	 * Returns an enum type of current part of sentence.
	 * @return
	 */
	Type getType();
}
