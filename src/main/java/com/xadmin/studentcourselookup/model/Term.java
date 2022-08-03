package com.xadmin.studentcourselookup.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//used for mapping to DB. creates table in DB with name Term and ID as primary key
@Entity
@Table(name = "term")
public class Term {
	@Id
	private int id;
	private String desc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}

//checkin code in github
//Add testcases first - follow TDD
//ID should be auto-generated and unique
// If table is not there then create table
//Naming convention can be improved
