/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;


/**
 *
 * @author doant
 */
public class Nurse extends Person implements Serializable{
//    final String id;
    private String staffID ;
    private String department ;
    private String shift;
    private double salary;

    public Nurse(String id, String name, int age, String gender, String address, String phone, String staffID, String department, String shift, double salary) {
        super(id, name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    
    public String getStaffID(){
        return this.staffID;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getShift(){
        return this.shift;
    }
    public double getSalary(){
        return this.salary;
    }
    
    public void setStaffID(String staffID){
        this.staffID = staffID;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setShift(String shift){
        this.shift = shift;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    
    
    
    public String toString(){
        return this.getID() +", "+ this.getName() +", "+ this.getAge() +", "+
                this.getGender()+", "+this.getAddress()+", "+this.getPhone()+", "+this.getStaffID()+", "+ this.getDepartment()+", "+this.getShift()+", "+this.getSalary();
    }
}
