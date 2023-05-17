/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import tools.Validator;
import model.Nurse;
import model.Patient;
import bussiness.NurseList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author doant
 */
public class HospitalManagement {


//    public HospitalManagement(HashMap<String, Nurse> n, HashMap<String, Patient> p) {
//        nurseList = n;
//        patientList = p;
//    }

    public NurseList readNurseFile(String path) throws Exception{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        NurseList nurses = (NurseList)ois.readObject();
        return nurses;
    }

    public void writeNurseListFile(String path, Object o) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
    }
    public void writePatientListFile(String path, Object o) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
    }
}
