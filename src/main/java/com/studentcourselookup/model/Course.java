package com.studentcourselookup.model;

import javax.persistence.*;

@Entity
@Table(name = "course_table")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", description=" + description + "]";
  }
}
