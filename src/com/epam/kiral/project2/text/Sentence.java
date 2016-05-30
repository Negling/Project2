package com.epam.kiral.project2.text;

import java.util.Iterator;
import java.util.List;

public class Sentence {
	private List<SentencePart> content;

	public Sentence(List<SentencePart> content) {
		this.content = content;
	}

	public List<SentencePart> getContent() {
		return content;
	}

	@Override
	public String toString() {
		Iterator<SentencePart> it = content.iterator();
		if (!it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		while (true) {
			SentencePart e = it.next();
			sb.append(e == content ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.toString();
		}
	}
}