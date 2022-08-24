package com.studentcourselookup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentcourselookup.exception.ResourceNotFoundException;
import com.studentcourselookup.model.Term;
import com.studentcourselookup.repository.TermRepository;


/*
 * create controller that provides APIs for 
 * CRUD operations: creating, retrieving, updating, deleting and finding Terms and Courses.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TermController {

	@Autowired
	TermRepository termRepository;
/*
	@GetMapping("/terms")
	public ResponseEntity<List<Term>> getAllTerm(@RequestParam(required = false) String title) {
		List<Term> terms = new ArrayList<Term>();
		System.out.println("terms***** " + terms);
		termRepository.findAll().forEach(terms::add);
		if (terms.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("TERMS*** " + terms);
		return new ResponseEntity<>(terms, HttpStatus.OK);
	}
	*/
	
	@GetMapping("terms")
    public ResponseEntity<List<Term>> getAll() {
		List<Term> terms = new ArrayList<Term>();
		termRepository.findAll().forEach(terms::add);
		if (terms.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("TERMS*** " + terms);
		return new ResponseEntity<>(terms, HttpStatus.OK);
    }

	@GetMapping("/terms/{id}")
	public ResponseEntity<Term> getTermById(@PathVariable("id") long id) {
		Term term = termRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Term with id = " + id));

		return new ResponseEntity<>(term, HttpStatus.OK);
	}

	@PostMapping("/terms")
	public ResponseEntity<Term> createTutorial(@RequestBody Term tutorial) {
		Term _term = termRepository.save(new Term(tutorial.getDescription()));
		return new ResponseEntity<>(_term, HttpStatus.CREATED);
	}

	@PutMapping("/terms/{id}")
	public ResponseEntity<Term> updateTutorial(@PathVariable("id") long id, @RequestBody Term term) {
		Term _term = termRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

		_term.setDescription(term.getDescription());

		return new ResponseEntity<>(termRepository.save(_term), HttpStatus.OK);
	}

	@DeleteMapping("/terms/{id}")
	public ResponseEntity<HttpStatus> deleteTerm(@PathVariable("id") long id) {
		termRepository.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/terms")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		termRepository.deleteAll();

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
