package app.springboot.hibernate.service;

import java.util.List;

import app.springboot.hibernate.dto.Catagory;

public interface CatService {
	
	public void addCatagory(Catagory catagory);

	public List<Catagory> getAllCatagory();

	public void deleteCatagory(Integer catagoryId);

	public Catagory getCatagory(int catagoryid);

	public Catagory updateCatagory(Catagory catagory); 
	
	public boolean validate(String emailId, String password);
}
