package br.com.desafio.springrestdatah2.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boleto {

	@Id
	@GeneratedValue
	private Long id;	
	private Date due_date;
	private int total_in_cents;
	private String customer;
	private String status;
	private String fine;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getTotal_in_cents() {
		return total_in_cents;
	}
	public void setTotal_in_cents(int total_in_cents) {
		this.total_in_cents = total_in_cents;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
	
	
	

}
