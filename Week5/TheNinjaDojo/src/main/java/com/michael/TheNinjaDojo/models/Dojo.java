package com.michael.TheNinjaDojo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

    @Column(updatable=false, name="created_at")
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createdAt;
    @Column(name="updated_at")
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;	

    @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
    private List<Ninja> ninjas;
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

    
    
}