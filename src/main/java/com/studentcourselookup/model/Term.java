package com.studentcourselookup.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "term_table")
public class Term {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  

  @Column(name = "description")
  private String description;

/*
 * OneToMany -> one term can have multiple courses
 * Here we are cascade course with all operation like persist, remove
 * FetchType -> 1) FetchType.EAGER: Fetch it so you’ll have it when you need it
 *              2) FetchType.LAZY -> Fetch it when you need it.
 *              
 * orphanRemoval is an entirely ORM-specific thing. It marks "child" entity to be removed when 
 * it's no longer referenced from the "parent" entity, 
 * 
 * 
 */

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "term_id")
  private Set<Course> courses = new HashSet<>();

  public Term() {

  }

  public Term(String description) {
   this.description = description;
  }

  public long getId() {
    return id;
  }

  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  
  public Set<Course> getCourses() {
    return courses;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }
  
  public void removeCourses() {
    this.courses.clear();
  }
  
  @Override
  public String toString() {
    return "Term [id=" + id +  ", desc=" + description +  "]";
  }

}
