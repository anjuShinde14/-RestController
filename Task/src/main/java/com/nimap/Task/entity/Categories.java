package com.nimap.Task.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	String cname;
	
	public Categories() {
		
	}
	
	public Categories(int cid, String cname) {
		super();
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "controller [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
