package com.nimap.Task.entity;

import java.util.Date;

import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Products {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String name;
	private String phoneno;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createddtm;
	
	private String createdby;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateddtm;
	
	private String updatedby;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Categories categories;

	public Products() {
		
	}

	public Products(String name, String phoneno, Date createddtm, String createdby, Date updateddtm, String updatedby,
			Categories categories) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.categories = categories;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", createddtm=" + createddtm
				+ ", createdby=" + createdby + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby
				+ ", categories=" + categories + "]";
	}
	
	
	
}
