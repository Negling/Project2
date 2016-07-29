package ua.kiral.project2.text;

public class Word implements SentencePart {
	private String word;
	
	public Word(String word) {
		this.word = word;
	}
	public String getContent(){
		return word;
	}

	@Override
	public Type getType() {
		return Type.WORD;
	}
	@Override
	public String toString() {
		return word;
	}

}
