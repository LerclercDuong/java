/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import model.Nurse;
import model.Patient;

/**
 *
 * @author doant
 */
public class PatientForm {
    public Patient addPatientForm() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        System.out.print("\nDiagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("\nAddmissionDate (dd/mm/yyyy): ");
        LocalDate addmissionDate = LocalDate.parse(sc.nextLine(), dateTimeFormatter );
        System.out.print("\nDischargeDate (dd/mm/yyyy): ");
        LocalDate dischargeDate = LocalDate.parse(sc.nextLine(), dateTimeFormatter );
        System.out.print("\nNurseAsigned: ");
        HashSet<String> nurseAssigned = new HashSet<String>();
        for(int i = 1; i <3; i++){
            System.out.print("\nEnter Nurse " + i + " staffID: ");
            String staffID = sc.nextLine();
            nurseAssigned.add(staffID);
        }
        
        
        Patient newPatient = new Patient(id, name, age, gender, address, phone, diagnosis, addmissionDate, dischargeDate, nurseAssigned);
        
        return newPatient;
    }
}
