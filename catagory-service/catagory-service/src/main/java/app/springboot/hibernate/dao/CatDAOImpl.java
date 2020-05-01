package app.springboot.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.springboot.hibernate.dto.Catagory;

@Repository
public class CatDAOImpl implements CatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCatagory(Catagory catagory) {
		sessionFactory.getCurrentSession().saveOrUpdate(catagory);
	}

	// @SuppressWarnings("unchecked")
	public List<Catagory> getAllCatagory() {
		return sessionFactory.getCurrentSession().createQuery("from Catagory").list();
	}

	@Override
	public void deleteCatagory(Integer id) {
		Catagory cat = (Catagory) sessionFactory.getCurrentSession().load(Catagory.class, id);
		if (null != cat) {
			this.sessionFactory.getCurrentSession().delete(cat);
		}
	}

	public Catagory getCatagory(int id) {
		return (Catagory) sessionFactory.getCurrentSession().get(Catagory.class, id);
	}

	@Override
	public Catagory updateCatagory(Catagory catagory) {
		sessionFactory.getCurrentSession().update(catagory);
		return catagory;
	}

	@Override
	public boolean validate(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Catagory emp = (Catagory) session.get(Catagory.class, email);
		if (emp != null) {
			return true;
		}
		/*
		 * try { Query query = session.
		 * createQuery("from emp_tbl as u where u.email=:userEmail And u.password=:userPassword"
		 * ); query.setParameter("userEmail", emailId);
		 * query.setParameter("userPassword", password);
		 * 
		 * List results = query.list();
		 * 
		 * if (results != null) return true; } catch (Exception e) {
		 * e.printStackTrace(); return false; }
		 */
		return false;
	}

}