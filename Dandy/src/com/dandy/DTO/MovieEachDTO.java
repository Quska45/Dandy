package com.dandy.DTO;

public class MovieEachDTO {

	private String morpheme;
	private int freq;
	private String word;
	private String meaning;
	private int wno;
	private String tablename;
	private String title;
	private String meaning2;
	
	
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

	
	
	
	
	public MovieEachDTO(String morpheme, String word, String meaning, String title, String meaning2) {
		super();
		this.morpheme = morpheme;
		this.word = word;
		this.meaning = meaning;
		this.title = title;
		this.meaning2 = meaning2;
	}


	public MovieEachDTO(String morpheme, String word, String meaning, String title) {
		super();
		this.morpheme = morpheme;
		this.word = word;
		this.meaning = meaning;
		this.title = title;
	}


	public MovieEachDTO(String morpheme, int freq, String meaning, String title) {
		super();
		this.morpheme = morpheme;
		this.freq = freq;
		this.meaning = meaning;
		this.title = title;
	}
	

	public MovieEachDTO(String title) {
		super();
		this.title = title;
	}


	public MovieEachDTO(String morpheme, String title) {
		super();
		this.morpheme = morpheme;
		this.title = title;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMeaning2() {
		return meaning2;
	}


	public void setMeaning2(String meaning2) {
		this.meaning2 = meaning2;
	}
	
	
	
	
	
	
	
	
}
