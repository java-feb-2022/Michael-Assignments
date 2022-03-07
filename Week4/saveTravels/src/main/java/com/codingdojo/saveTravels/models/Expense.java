package com.codingdojo.saveTravels.models;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
	@NotNull(message="Please enter an expense name")
	@Size(min = 3, max = 200, message = "Expense Name must contain at least 3 characters")
    private String name;

	@NotNull(message="Please enter a vendor name")
	@Size(min = 3, max = 200, message = "Vendor Name's must contain 3 characters")
	private String vendor;
	
	@NotNull(message ="Please enter an amount:")
	@Min(value = 1, message="The amount must be 1 or greater")
    private double amount;
    
    @NotNull(message="Please enter a description")
    @Size(min = 3, max = 200, message="Description must be 3 characters")
    private String description;
   
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;    
    
    // Constructor here
    public Expense() {
	}

    
    	public Expense(@NotNull String name, @NotNull String vendor, @NotNull @Min(0) Double amount, @NotNull String description) {
    		this.name = name;
    		this.vendor = vendor;
    		this.amount = amount;
    		this.description = description;
    	}
	
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }

    // Getters and Setters
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


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
