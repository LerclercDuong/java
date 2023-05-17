/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import java.util.HashMap;
import model.Nurse;
import model.Patient;
import bussiness.NurseList;
import bussiness.PatientList;
import java.util.ArrayList;
import view.NurseForm;
import controller.HospitalManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author doant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        String[] options = {"Create a nurse",
            "Find a nurse", "Update a nurse",
            "Delete a nurse", "Add a patient",
            "Display patient", "Sort patients", "Quit and Save data",};
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        final String fileNurse = "src\\output\\NurseList.dat";
//        final String fileOutputNurse = "src\\output\\NurseList.dat";
        final String filePatient = "src\\output\\PatientList.dat";

        Nurse n1 = new Nurse("SE0040", "Ngoc Trinh", 29, "Female", "Ho Chi Minh city", "0945377377", "N00023", "P007", "night", 11);
        Nurse n2 = new Nurse("SE0019", "Ha Linh", 20, "Female", "Ho Chi Minh city", "0544944767", "N00046", "P003", "morning", 12.5);
        Nurse n3 = new Nurse("SE0063", "Trang Tran", 23, "Female", "Ho Chi Minh city", "0672903078", "N00034", "P0015", "night", 16.2);
        Nurse n4 = new Nurse("SE0056", "Thanh Ngan", 22, "Female", "Ho Chi Minh city", "0973142999", "N00024", "P009", "noon", 15.5);
        Nurse n5 = new Nurse("SE0020", "Thu Hoai", 24, "Female", "Ho Chi Minh city", "0522444555", "N00041", "P002", "night", 10);
        Nurse n6 = new Nurse("SE0044", "Thuy Linh", 35, "Female", "Ho Chi Minh city", "0989999999", "N00043", "P004", "night", 15);
        NurseList nurseList = new NurseList();
        nurseList.add(n1);
        nurseList.add(n2);
        nurseList.add(n3);
        nurseList.add(n4);
        nurseList.add(n5);
        nurseList.add(n6);
        
        HashSet<String> nl = new HashSet<String>();
        Patient p1 = new Patient("052244", "Nguyen Van A", 23, "Male", "Viet Nam", "0934599999", "flu", LocalDate.parse("23/02/2019", dateTimeFormatter ), LocalDate.parse("16/12/2020", dateTimeFormatter), nl );
        Patient p2 = new Patient("023244", "Nguyen Van B", 12, "Male", "Viet Nam", "0999566999", "covid", LocalDate.parse("20/04/2012", dateTimeFormatter ), LocalDate.parse("12/12/2023", dateTimeFormatter), nl );
        Patient p3 = new Patient("052674", "Nguyen Van C", 22, "Male", "Viet Nam", "0999956999", "muscle pain", LocalDate.parse("23/06/2022", dateTimeFormatter ), LocalDate.parse("12/08/2022", dateTimeFormatter), nl );
        Patient p4 = new Patient("042464", "Nguyen Van D", 25, "Male", "Viet Nam", "0559449999", "flu", LocalDate.parse("12/02/2022", dateTimeFormatter ), LocalDate.parse("12/12/2022", dateTimeFormatter), nl );
        
        PatientList patientList = new PatientList();
        HospitalManagement hospitalManage = new HospitalManagement();
        patientList.add(p1);
        patientList.add(p2);
        patientList.add(p3);
        patientList.add(p4);
//        try {
//            nurseList = hospitalManage.readNurseFile(fileNurse);
//        } catch (Exception err) {
//            System.out.println(err.getMessage());
//        }
        
//        if(nurseList.isEmpty() == true){
//            System.out.print("hhhhhh");
//        }
//        try {
                            for (Nurse i : nurseList.values()) {
                                System.out.println(i.toString());
                            }
//                        } catch (Exception err) {
//                            System.out.println(err.getMessage());
//                        }
        
        
        
        Scanner sc = new Scanner(System.in);
        String choice;
        boolean again = true;
        do {
            System.out.println("\nHospital Management program");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.print("=> Select your options 1 - 10: ");
            try {
                choice = sc.nextLine();

                Pattern pattern = Pattern.compile("^(?:[1-9]|0[1-9])$");
                Matcher matcher = pattern.matcher(String.valueOf(choice));

                if (matcher.matches() == false) {
                    throw new Exception("Out of choice range");
                }
                switch (Integer.parseInt(choice)) {
                    case 1: // add nurse
                        NurseForm a = new NurseForm();
                        try {
                            Nurse newNurse = a.addNurseForm();
                            nurseList.add(newNurse);
                        } catch (Exception err) {
                            System.out.println("Error: Invalid value");
                        }
                        break;
                    case 2: // find nurse by name
                        try {
                            ArrayList<Nurse> resultList = new ArrayList<Nurse>();
                            System.out.print("\nEnter nurse name: ");
//                            sc.nextLine();
                            String nurseName = sc.nextLine();
                            resultList = nurseList.find(nurseName);
                            for (Nurse i : resultList) {
                                System.out.println(i.toString());
                            }
                        } catch (Exception err) {
                            System.out.println(err.getMessage());
                        }
                        break;
                    case 3: // update nurse by staffID
                        try {
                            System.out.print("\nEnter nurse staffID: ");
                            String nurseStaffID;
                            sc.nextLine();
                            nurseStaffID = sc.nextLine();
                            nurseList.update(nurseStaffID);

                        } catch (Exception err) {
                            System.out.println("\n" + err.getMessage());
                        }
                        break;
                    case 4: // delete nurse by staffID
                        try {
                            System.out.print("\nEnter nurse staffID: ");
                            String nurseStaffID;
                            sc.nextLine();
                            nurseStaffID = sc.nextLine();
                            nurseList.remove(nurseStaffID);

                        } catch (Exception err) {
                            System.out.println("\n" + err.getMessage());
                        }
                        break;
                    case 5:
                        PatientForm p = new PatientForm();
                        Patient newPatient = p.addPatientForm();
                        try {
                            patientList.add(newPatient);
                        } catch (Exception err) {
                            System.out.println(err.getMessage());
                        }

                        break;
                    case 6:
                        
                        System.out.print("\nStart date (dd/mm/yyyy): ");
                        String startDate = sc.nextLine();
                        System.out.print("\nEnd date (dd/mm/yyyy): ");
                        String endDate = sc.nextLine();
                        System.out.println("\nShow patient list: ");
                        try {
                            patientList.showList(LocalDate.parse(startDate, dateTimeFormatter), LocalDate.parse(endDate, dateTimeFormatter));
                        } catch (Exception err) {
                            System.out.println(err.getMessage());
                        }
                        break;
                    case 7:
                        System.out.print("\nEnter sort field ( enter 1 for id, enter 2 for name): ");
                        int field = sc.nextInt();
                        System.out.print("\nEnter sort order ( ASC, DSC): ");
                        sc.nextLine();
                        String order = sc.nextLine();
                        patientList.sortPatient(field, order);
                        break;
                    case 8: // write file
                        try {
                            hospitalManage.writeNurseListFile(fileNurse, nurseList);
                            hospitalManage.writePatientListFile(filePatient, patientList);
                        } catch (IOException err) {
                            System.out.println(err.getMessage());
                        }
                    case 9: // exit confirmation
                        System.out.print("Warning: Exit confirmation (Y/N): ");
//                        sc.nextLine();
                        String pick = sc.nextLine();
                        if (pick.equals("Y")) {
                            again = false;
                        }
                        break;
                    default:
                        System.out.println("Good bye!");
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }

        } while (again);

    }

}
