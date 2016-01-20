package com.globant.Topic2;

/**
 * Class that represents a blog entry.
 * @author Eduardo Salgueiro
 *
 */
public class BlogEntry {
	private String author;
	private String title;
	private String text;

	public BlogEntry(String author, String title, String text) {
		this.author = author;
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}
	public String toString() {
		return "Author: "+author+" Entry Title: "+title+ " Entry Text: "+text;
	}

}
