package net.studentcourse.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.studentcourse.springboot.model.Term;
import net.studentcourse.springboot.repository.TermRepository;

@Service
public class TermService {

	@Autowired
	private TermRepository termRepository;

	public List<Term> getAllTerms() {
		List<Term> terms = new ArrayList<>();
		termRepository.findAll().forEach(terms::add);
		return terms;
	}

}
