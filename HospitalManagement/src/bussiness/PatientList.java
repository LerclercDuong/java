/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import model.Nurse;
import tools.Validator;
import model.Patient;

/**
 *
 * @author doant
 */
public class PatientList extends HashMap<String, Patient> {

    public void add(Patient n) {
        Validator v = new Validator();
        boolean patientValidated = v.patientValidate(n, this);
        if (patientValidated == true) {
            this.put(n.getID(), n);
            System.out.println("=> Adding successfully");
        } else {
            System.out.println("=> Adding failure");
        }
    }

    public void showList(LocalDate startDate, LocalDate endDate) throws Exception {
        if(this.isEmpty() == true){
            throw new Exception("Patient Not Found.");
        }
        System.out.println(String.format("%6s %16s %14s %12s %12s", "id", "AdmissionDate", "Name", "Phone", "Diagnosis"));
        for (Patient i : this.values()) {
            if(i.getAdmissionDate().isAfter(startDate) && i.getAdmissionDate().isBefore(endDate))
            {
                System.out.println(i.toString());
            }
        }

    }
    
    public void sortPatient(int sortField, String order){
        ArrayList<Patient> list = new ArrayList<Patient>();
        for(Patient i: this.values()){
            list.add(i);
        }
        switch(sortField){
            case 1: //sort by id
                if(order.equals("ASC")){
                    list.sort((o1, o2)
                    -> Integer.compare(Integer.parseInt(o1.getID()), Integer.parseInt(o2.getID())));
                }if(order.equals("DSC")){
                    list.sort((o2, o1)
                    -> Integer.compare(Integer.parseInt(o1.getID()), Integer.parseInt(o2.getID())));
                }
                for(Patient e: list){
                    System.out.println(e.toString());
                }
                break;
        }
    }
}
