package net.studentcourse.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.studentcourse.springboot.model.Term;

@Repository
public interface TermRepository extends CrudRepository<Term, Integer>{

}
