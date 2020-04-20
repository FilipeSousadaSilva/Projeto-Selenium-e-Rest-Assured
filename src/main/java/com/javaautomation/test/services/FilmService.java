package com.javaautomation.test.services;

import java.util.ArrayList;

import com.javaautomation.test.model.Film;

public class FilmService {
	private ArrayList<Film> filmList;
	
	public FilmService() {
		this.filmList = new ArrayList<Film>();
	}
	
	public ArrayList<Film> insertFilm(String name,String releaseYear){
		Film film = new Film();
		film.setName(name);
		film.setReleaseYear(releaseYear);
		this.filmList.add(film);
		return this.filmList; 
	}
	
	public String getFilmToSearch() {
		return !this.filmList.isEmpty()
				? this.filmList.get(0).getName() : "";
	}
}
