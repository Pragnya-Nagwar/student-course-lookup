package com.xadmin.studentcourselookup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.studentcourselookup.dao.TermDao;
import com.xadmin.studentcourselookup.model.Term;
// @RestConroller to mark as request handler
@RestController
@RequestMapping("/orm")
public class TermController {
 
	@Autowired
	private TermDao dao;
	
	//we dont have functionality to save term we can avoid this endpoint
	/*
	 * @PostMapping("/saveTerm") public String save(@RequestBody Term term) {
	 * dao.saveTerm(term); return "saved successfully";
	 * 
	 * }
	 */
	
	@GetMapping("/getAllTerms")
	public List<Term> getAllTerm(){
		return dao.getterms();
	}
}
