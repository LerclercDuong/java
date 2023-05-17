/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

/**
 *
 * @author doant
 */
public class Patient extends Person {
    private String diagnosis;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private HashSet<String> nursesAssigned;

    public Patient(String id, String name, int age, String gender, String address, String phone, String diagnosis, LocalDate admissionDate, LocalDate dischargeDate, HashSet<String> nursesAssigned) {
        super(id, name, age, gender, address, phone);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.nursesAssigned = nursesAssigned;
    }
    
    
    public String getDiagnosis(){
        return this.diagnosis;
    }
    public LocalDate getAdmissionDate(){
        return this.admissionDate;
    }
    public LocalDate getDischargeDate(){
        return this.dischargeDate;
    }
    public HashSet<String> getNursesAssigned(){
        return this.nursesAssigned;
    }
    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }
    public void setAdmissionDate(LocalDate admissionDate){
        this.admissionDate = admissionDate;
    }
    public void setDischargeDate(LocalDate dischargeDate){
        this.dischargeDate = dischargeDate;
    }
    public void setNurseAssigned(HashSet<String> nursesAssigned){
        this.nursesAssigned = nursesAssigned;
    }
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    public String toString(){
        return String.format("%6s %16s %14s %12s %12s", this.getID(), String.valueOf(this.getAdmissionDate().format(dateTimeFormatter)), this.getName(), this.getPhone(), this.getDiagnosis());
    }
}
