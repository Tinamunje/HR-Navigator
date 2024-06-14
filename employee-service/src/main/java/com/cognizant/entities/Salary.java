package com.cognizant.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Salary")
public class Salary {
	
	@Id
	@Column(name="Employee_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(name="Account_No")
	private String accountNo;
	@Column(name="Month_Pay")
	private double monthPay;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(double monthPay) {
		this.monthPay = monthPay;
	}
	


}
