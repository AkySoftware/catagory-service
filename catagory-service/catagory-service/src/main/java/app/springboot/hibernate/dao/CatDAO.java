package app.springboot.hibernate.dao;

import java.util.List;

import app.springboot.hibernate.dto.Catagory;

public interface CatDAO {

	public void addCatagory(Catagory catagory);

	public List<Catagory> getAllCatagory();

	public void deleteCatagory(Integer id);

	public Catagory updateCatagory(Catagory catagory);

	public Catagory getCatagory(int id);
	
	public boolean validate(String emailId, String password);
}
