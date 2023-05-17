/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import tools.Validator;
import model.Nurse;
import model.Patient;
import java.util.Scanner;
import view.NurseForm;

/**
 *
 * @author doant
 */
public class NurseList extends HashMap<String, Nurse> implements Serializable {
    
    

    public void add(Nurse n) {
        Validator v = new Validator();
        boolean nurseValidated = v.nurseValidate(n, this);
        if (nurseValidated == true) {
            this.put(n.getStaffID(), n);
            System.out.println("=> Adding successfully");
        }else{
            System.out.println("=> Adding failure");
        }
    }

    public ArrayList<Nurse> find(String nameSearch) throws Exception {
        
        ArrayList<Nurse> findList = new ArrayList<Nurse>();
        for (Nurse i : this.values()) {
            if (nameSearch.equals(i.getName())) {
                findList.add(i);
            }
        }
//        if (findList.isEmpty()) {
//            throw new Exception("The nurse is not exist");
//        }
        return findList;

    }

    public void update(String sID) throws Exception {
        NurseForm a = new NurseForm();
        boolean nurseNotFound = true;
        boolean update_complete = false;
        Nurse nurseFound = this.get(sID);
        if(nurseFound == null){
            throw new Exception("The nurse is not exist");
        }
        System.out.println(nurseFound.toString());
        a.updateNurseForm(nurseFound, this);
        
//        return update_complete;
    }
    
    public void detete(String staffID) throws Exception{
        boolean nurseNotFound = true;
        for (Nurse i : this.values()) {
            if (staffID.equals(i.getStaffID())) {
                nurseNotFound = false;
                this.remove(i.getStaffID(), i);
                System.out.println("Deleting completely");
                break;
            }
        }
        if(nurseNotFound == true){
            throw new Exception("The Nurse not found");
        }
    }
    
}
