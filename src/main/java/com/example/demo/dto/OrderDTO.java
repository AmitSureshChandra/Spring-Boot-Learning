package com.example.demo.dto;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;

public class OrderDTO {
    private Boolean status;
    private User user;
    private Invoice invoice;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
    
    
}
