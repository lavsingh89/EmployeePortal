package com.employeeportal.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String department;

    public Integer getEmployeeId() {
	return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public Date getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
	return department;
    }

    public void setDepartment(String department) {
	this.department = department;
    }

    @Override
    public int hashCode() {
	return Objects.hash(dateOfBirth, department, employeeId, firstName, gender, lastName);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof Employee)) {
	    return false;
	}
	Employee other = (Employee) obj;
	return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(department, other.department)
		&& Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
		&& Objects.equals(gender, other.gender) && Objects.equals(lastName, other.lastName);
    }

}
