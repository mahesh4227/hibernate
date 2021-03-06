package com.mahesh.hibernate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Employee {
 
    //private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String name;
    private int sal;
    private String city;
    private int phone;
 
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
 
    public int getSal() {
        return sal;
    }
 
    public void setSal(int sal) {
        this.sal = sal;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public int getPhone() {
        return phone;
    }
 
    public void setPhone(int phone) {
        this.phone = phone;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", city=" + city + ", phone=" + phone + "]";
	}
    
    
 
}