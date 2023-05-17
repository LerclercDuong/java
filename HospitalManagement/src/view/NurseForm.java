/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import model.Nurse;

/**
 *
 * @author doant
 */
public class NurseForm {

    public Nurse addNurseForm() throws Exception {
        
            Scanner sc = new Scanner(System.in);       
            System.out.print("\nId: ");
            String id = sc.nextLine();
            System.out.print("\nName: ");
            String name = sc.nextLine();
            System.out.print("\nAge: ");
            int age = sc.nextInt();sc.nextLine();
            System.out.print("\nGender: ");
            String gender = sc.nextLine();
            System.out.print("\nAddress: ");
            String address = sc.nextLine();
            System.out.print("\nPhone: ");
            String phone = sc.nextLine();
            System.out.print("\nStaffID: ");
            String staffID = sc.nextLine();
            System.out.print("\nDepartment: ");
            String department = sc.nextLine();
            System.out.print("\nShift: ");
            String shift = sc.nextLine();
            System.out.print("\nSalary: ");
            double salary = Double.parseDouble(sc.nextLine());
        
        
        Nurse newNurse = new Nurse(id, name, age, gender, address, phone, staffID, department, shift, salary);
        
        return newNurse;
    }
    
    public void updateNurseForm(Nurse n, HashMap<String, Nurse> nurseList) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;
        String[] editOptions = {"Id", "Name", "Age", "Gender", "Address", "Phone","staffID", "Department", "Shift", "Salary", "Finish"};
        for (int i = 0; i < editOptions.length; i++) {
            System.out.println((i + 1) + ":" + editOptions[i]);
        }
        do {
            System.out.print("\nSelect field you want to edit:");
            choice = sc.nextInt(); // show Menu options
            switch (choice) {
                case 1:
                    System.out.print("\nEnter id: ");
                    String id;
                    sc.nextLine();
                    id = sc.nextLine();
                    n.setID(id);
                    break;
                
                case 2:
                    System.out.print("\nEnter name: ");
                    String name;
                    sc.nextLine();
                    name = sc.nextLine();
                    n.setName(name);
                    break;
                case 3:
                    System.out.print("\nEnter age: ");
                    int age;
                    age = sc.nextInt();
                    n.setAge(age);
                    break;
                case 4:
                    System.out.print("\nEnter gender: ");
                    String gender;
                    sc.nextLine();
                    gender = sc.nextLine();
                    n.setGender(gender);
                    break;
                case 5:
                    System.out.print("\nEnter address: ");
                    String address;
                    sc.nextLine();
                    address = sc.nextLine();
                    n.setAddress(address);
                    break;
                case 6:
                    System.out.print("\nEnter phone: ");
                    String phone;
                    sc.nextLine();
                    phone = sc.nextLine();
                    n.setPhone(phone);
                    break;
                case 7:
                    System.out.print("\nEnter staffID: ");
                    String staffID;
                    sc.nextLine();
                    staffID = sc.nextLine();
                    n.setStaffID(staffID);
                    break;
                case 8:
                    System.out.print("\nEnter department: ");
                    String department;
                    sc.nextLine();
                    department = sc.nextLine();
                    n.setDepartment(department);
                   
                    break;
                case 9:
                    System.out.print("\nEnter shift: ");
                    String shift;                  
                    shift = sc.nextLine();
                    n.setShift(shift);
                    break;
                case 10:
                    System.out.print("\nEnter salary: ");
                    double salary;
                    salary = sc.nextDouble();
                    n.setSalary(salary);
                    break;
                default:
                    System.out.println("Update Finish");
            }
        } while (choice > 0 && choice < editOptions.length);
    }
}
