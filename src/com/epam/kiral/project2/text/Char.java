package com.epam.kiral.project2.text;

public class Char implements SentencePart {
	private Character character;
	private Type type;

	public Char(Character character, Type type) {
		this.character = character;
		this.type = type;
	}

	public Character getContent() {
		return character;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return character.toString();
	}
}
