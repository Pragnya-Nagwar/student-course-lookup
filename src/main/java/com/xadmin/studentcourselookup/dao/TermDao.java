package com.xadmin.studentcourselookup.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xadmin.studentcourselookup.model.Term;

@Repository
@Transactional
public class TermDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null) {
			session = factory.openSession();
		}
		
		return session;
	}
	
	// save data in term table
	/*
	 * public void saveTerm(Term term) { getSession().save(term); }
	 */
	
	
	//get list of terms
	@SuppressWarnings("deprecation")
	public List<Term> getterms(){
		return getSession().createCriteria(Term.class).list();
	}

}
