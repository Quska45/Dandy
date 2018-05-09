package com.dandy.DTO;

public class MovieEachDTO {

	private String morpheme;
	private int freq;
	private String word;
	private String meaning;
	private int wno;
	private String tablename;
	
	
	public MovieEachDTO() {
		super();
	}


	public MovieEachDTO(String morpheme, int freq, String word, String meaning, int wno) {
		super();
		this.morpheme = morpheme;
		this.freq = freq;
		this.word = word;
		this.meaning = meaning;
		this.wno = wno;
	}


	public String getMorpheme() {
		return morpheme;
	}


	public void setMorpheme(String morpheme) {
		this.morpheme = morpheme;
	}


	public int getFreq() {
		return freq;
	}


	public void setFreq(int freq) {
		this.freq = freq;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}


	public int getWno() {
		return wno;
	}


	public void setWno(int wno) {
		this.wno = wno;
	}


	public String getTablename() {
		return tablename;
	}


	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	
	
	
	
	
	
	
}
