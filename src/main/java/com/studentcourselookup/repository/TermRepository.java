package com.studentcourselookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentcourselookup.model.Term;


/*
 * Repository to interact with database
 *  we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(),
 *   deleteById()… without implementing these methods.
 *   
 *   The implementation is plugged in by Spring Data JPA automatically.
 */

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
 
}
