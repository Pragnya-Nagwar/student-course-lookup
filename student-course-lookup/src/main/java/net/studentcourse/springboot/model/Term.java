package net.studentcourse.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "term")
public class Term {
	@Id
	Integer termId;
	String termDesc;
	
	public Term() {
		
	}
	public Term(Integer termId, String termDesc) {
		super();
		this.termId = termId;
		this.termDesc = termDesc;
	}
	public int gettermId() {
		return termId;
	}
	public void settermId(int id) {
		this.termId = id;
	}
	public String gettermDesc() {
		return termDesc;
	}
	public void settermDesc(String desc) {
		this.termDesc = desc;
	}

}
