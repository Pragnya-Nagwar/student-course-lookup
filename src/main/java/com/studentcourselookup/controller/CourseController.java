package com.studentcourselookup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studentcourselookup.exception.ResourceNotFoundException;
import com.studentcourselookup.model.Course;
import com.studentcourselookup.model.Term;
import com.studentcourselookup.repository.CourseRepository;
import com.studentcourselookup.repository.TermRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private TermRepository termRepository;

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public ResponseEntity<List<Course>> getAll() {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);
		if (courses.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("courses*** " + courses);
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	// add it in termController
	//instead of ResourceNotFoundException CourseNotFound
	//incase of Hibernate and sql it should be 500 error
	//
	@GetMapping("/terms/{termId}/courses")
	public ResponseEntity<List<Course>> getAllCoursesByTermId(@PathVariable(value = "termId") Long termId) {
		Term term = termRepository.findById(termId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Term with id = " + termId));
//can use diamond
		List<Course> courses = new ArrayList<Course>();
		courses.addAll(term.getCourses());

		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCoursesByTermId(@PathVariable(value = "id") Long id) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Course with id = " + id));

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@PathVariable(value = "termId") Long termId,

			@RequestBody Course courseRequest) {
		System.out.println("POST Course***** ");
		Course course = termRepository.findById(termId).map(term -> {
			term.getCourses().add(courseRequest);
			return courseRepository.save(courseRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Term with id = " + termId));

		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course courseRequest) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CourseId " + id + "not found"));

		course.setDescription(courseRequest.getDescription());

		return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
		courseRepository.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/terms/{termId}/courses")
	public ResponseEntity<List<Course>> deleteAllCoursesOfTerm(@PathVariable(value = "termId") Long termId) {
		Term term = termRepository.findById(termId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Term with id = " + termId));

		term.removeCourses();
		termRepository.save(term);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
