package com.username.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restrictedWords")
public class RestrictedWords {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	 @Column(name = "word")
	private String word;

	@Override
	public String toString() {
		return "RestrictedWords [id=" + id + ", word=" + word + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
