package com.mahesh.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.mahesh.hibernate.Employee;
import com.mahesh.util.HibernateUtil;
 
public class Main {
    public static void main(String[] args) {
    	while(true)
    	{
    	Scanner scan=new Scanner(System.in);
    	System.out.println("press 1 to insert employees"+"\n"+"press 2 for deleting employees"+"\n"+"press 3 for updating employee details"+"\n"+"press 4 to list of all employees");
    	int num=scan.nextInt();
        Main main = new Main();
        if(num==1)
        main.saveEmployee();
        else if(num==2)
        main.deleteEmployee();
        else if(num==3)
        main.updateEmployee();
        else if(num==4)
        main.retriveEmployee();
        else
        {
        	System.out.println("Lo correct agi nodi enter madu!!!! kannu kansalva??");
        }
        System.out.println();
    	}
    }
 
    public void saveEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
 
        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee();
            Scanner scan=new Scanner(System.in);
            System.out.println("enter employee id");
            int id=scan.nextInt();
            employee.setId(id); 
            System.out.println("enter employee name");
            String name=scan.next();
            employee.setName(name);
            System.out.println("enter employee salary");
            int sal=scan.nextInt();
            employee.setSal(sal);
            System.out.println("enter employee city");
            String city=scan.next();
            employee.setCity(city);
            System.out.println("enter employee phone number");
            int phone=scan.nextInt();
            employee.setPhone(phone);
            session.save(employee);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
 
    }
 
    public void retriveEmployee()
 
    {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List employee = session.createQuery("from Employee").list();
            for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
                Employee employee1 = (Employee) iterator.next();
                System.out.println(employee1.getId() +"  "+employee1.getName() + "  "
                        + employee1.getCity() + "  " + employee1.getSal()
                        + "  " + employee1.getPhone());
            }
            transaction.commit();
 
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }
    
    @Transactional
    public void deleteEmployee() {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
        	Scanner scan=new Scanner(System.in);
        	System.out.println("enter the employee's ID whose data you want to delete");
        	int n=scan.nextInt();
            transaction = session.beginTransaction();
            String queryString = "delete from Employee where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",n);
            int rowsAffected = query.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " rows.");
            }
           // Employee employee = (Employee) query.setMaxResults(1).uniqueResult();
            //Employee employee =new Employee();
           // employee.setId(7);
            //session.delete(employee);
            transaction.commit();
            System.out.println("Employee records deleted!");
            System.out.println();
 
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }
 
    public void updateEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
        	Scanner scan=new Scanner(System.in);
        	System.out.println("enter the employee's Id whose details you want to update");
        	int n=scan.nextInt();
        	System.out.println("press 1 to update salary\n"+"press 2 to update phone number\n"+"press 3 to update employee name\n"+"press 4 to update city");
        	int num=scan.nextInt();
            transaction = session.beginTransaction();
            if(num==1)
        	{
        		System.out.println("enter the salary amount you want to update");
        		int s=scan.nextInt();
        		String queryString = "update Employee set sal= :sal where id = :id";
                Query query = session.createQuery(queryString);
                query.setInteger("sal",s);
                query.setInteger("id",n);
                int rowsAffected = query.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Updated " + rowsAffected + " rows.");
                    System.out.println("Employee records updated!");
                    System.out.println();
                    transaction.commit();
                }
        	}
            else if(num==2)
        	{
        		System.out.println("enter the phone number you want to update");
        		int p=scan.nextInt();
        		String queryString = "update Employee set phone= :phone where id = :id";
                Query query = session.createQuery(queryString);
                query.setInteger("phone",p);
                query.setInteger("id",n);
                int rowsAffected = query.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Updated " + rowsAffected + " rows.");
                    System.out.println("Employee records updated!");
                    System.out.println();
                    transaction.commit();
                }
        	}
            else if(num==3)
        	{
        		System.out.println("enter the employee name you want to update");
        		String m=scan.next();
        		String queryString = "update Employee set name= :name where id = :id";
                Query query = session.createQuery(queryString);
                query.setString("name",m);
                query.setInteger("id",n);
                int rowsAffected = query.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Updated " + rowsAffected + " rows.");
                    System.out.println("Employee records updated!");
                    System.out.println();
                    transaction.commit();
                }
        	}
            else if(num==4)
        	{
        		System.out.println("enter the city name you want to update");
        		String o=scan.next();
        		String queryString = "update Employee set city= :city where id = :id";
                Query query = session.createQuery(queryString);
                query.setString("city",o);
                query.setInteger("id",n);
                int rowsAffected = query.executeUpdate();
                if (rowsAffected > 0) {
                System.out.println("Updated " + rowsAffected + " rows.");
                System.out.println("Employee records updated!");
                System.out.println();
                transaction.commit();
            }
        	}
            else
            {
            	System.out.println("Thoo kannu kansalva???!!!");
            	System.out.println("Employee details have not been updated!!!correct agi nodi type madu..!!");
                System.out.println();
            }
            //Employee employee = (Employee) query.setMaxResults(1).uniqueResult();
           // employee.setSal(60000);
           // session.update(employee);
        } catch (HibernateException e) {
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
        }
        
    }
}