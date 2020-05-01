package app.springboot.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.springboot.hibernate.dao.CatDAO;
import app.springboot.hibernate.dto.Catagory;

@Service
@Transactional
public class CatServiceImpl implements CatService {

	@Autowired
	private CatDAO catagoryDAO;

	@Override
	@Transactional
	public void addCatagory(Catagory catagory) {
		catagoryDAO.addCatagory(catagory);
	}

	@Override
	@Transactional
	public List<Catagory> getAllCatagory() {
		return catagoryDAO.getAllCatagory();
	}

	@Override
	@Transactional
	public void deleteCatagory(Integer employeeId) {
		catagoryDAO.deleteCatagory(employeeId);
	}

	public Catagory getCatagory(int empid) {
		return catagoryDAO.getCatagory(empid);
	}

	public Catagory updateCatagory(Catagory catagory) {
		// TODO Auto-generated method stub
		return catagoryDAO.updateCatagory(catagory);
	}

	@Override
	public boolean validate(String emailId, String password) {
		return catagoryDAO.validate(emailId, password);
	}

}
