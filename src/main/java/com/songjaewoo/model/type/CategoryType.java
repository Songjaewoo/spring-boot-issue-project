package com.songjaewoo.model.type;

public enum CategoryType {
	free(1), crawling(2);

	public final Integer seq;

	CategoryType(final Integer seq) {
		this.seq = seq;
	}
}
