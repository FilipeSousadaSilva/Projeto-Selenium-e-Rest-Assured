package com.javaautomation.test.services;

import java.util.ArrayList;

import com.javaautomation.test.model.Director;

public class DirectorService {
private ArrayList<Director> directorList;
	
	public DirectorService() {
		this.directorList = new ArrayList<Director>();
	}
	
	public ArrayList<Director> insertDirector(String name,String birthDate){
		Director director = new Director();
		director.setName(name);
		director.setBirthDate(birthDate);
		this.directorList.add(director);
		return this.directorList; 
	}
	
	public String getDirectorToSearch() {
		return !this.directorList.isEmpty()
				? this.directorList.get(0).getName() : "";
	}
}
