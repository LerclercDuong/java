/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import model.Nurse;
import model.Patient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author doant
 */
public class Validator {

    public boolean nurseValidate(Nurse n, HashMap<String, Nurse> NurseList) {
        boolean validated = true;
        String[] errors = {"All fields are not allowed null.",
            "The staffID field must be unique.",
            "The length of the department field must be from 3 to 50 characters.",
            "The import phone field must be a valid phone format.",
            "The age field must be a positive number.",
            "The salary field must be a positive number."
        };
        String id = n.getID();
        String name = n.getName();
        String gender = n.getGender();
        String address = n.getAddress();
        String department = n.getDepartment();
        String phone = n.getPhone();
        String staffID = n.getStaffID();
        String age = String.valueOf(n.getAge());
        String salary = String.valueOf(n.getSalary());

        if (id.isEmpty() || name.isEmpty() || gender.isEmpty() || address.isEmpty() || department.isEmpty() || phone.isEmpty() || age.isEmpty() || salary.isEmpty()) {
            validated = false;
            System.out.println("Error: " + errors[0]);
        }

        for (Nurse i : NurseList.values()) {
            if (staffID.equals(i.getID())) {
                System.out.println("Error: id must be unique");
                validated = false;
            }
        }

        for (Nurse i : NurseList.values()) {
            if (staffID.equals(i.getStaffID())) {
                System.out.println("Error: " + errors[1]);
                validated = false;
            }
        }

        if (department.length() < 3 || department.length() > 50) {
            System.out.println("Error: " + errors[2]);
            validated = false;
        }

        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches() == false) {
            System.out.println("Error: " + errors[3]);
            validated = false;
        }
        if (Integer.parseInt(age) < 0) {
            System.out.println("Error: " + errors[4]);
            validated = false;
        }

        if (Double.parseDouble(salary) < 0) {
            System.out.println("Error: " + errors[5]);
            validated = false;
        }

        return validated;
    }

    public boolean patientValidate(Patient n, HashMap<String, Patient> Patient) {
        boolean validated = true;
        String[] errors = {"All fields are not allowed null.",
            "The ID field must be unique.",
            " The admissionDate, dischargeDate fields must be a valid date format.",
            "The import phone field must be a valid phone format.",
            "The age field must be a positive number.",
            "The salary field must be a positive number.", "The nurseAssigned field must be on the list of available nurses."

        };


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        
        String id = n.getID();
        String name = n.getName();
        String gender = n.getGender();
        String address = n.getAddress();
        String phone = n.getPhone();
        String diagnosis = n.getDiagnosis();
        LocalDate addmissionDate = n.getAdmissionDate();
        LocalDate dischargeDate = n.getDischargeDate();
        String age = String.valueOf(n.getAge());

        if (id.isEmpty() || name.isEmpty() || gender.isEmpty() || address.isEmpty() || phone.isEmpty() || age.isEmpty() || diagnosis.isEmpty() || String.valueOf(addmissionDate).isEmpty() || String.valueOf(dischargeDate).isEmpty()) {
            validated = false;
            System.out.println("Error: " + errors[0]);
        }

        Pattern DATE_PATTERN = Pattern.compile(
                "^29/02/((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26])))$"
                + "|^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$"
                + "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$"
                + "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$");
        Matcher matcherAddmission = DATE_PATTERN.matcher(String.valueOf(addmissionDate.format(dateTimeFormatter)));
        Matcher matcherDischarge = DATE_PATTERN.matcher(String.valueOf(dischargeDate.format(dateTimeFormatter)));

        if (matcherAddmission.matches() == false || matcherDischarge.matches() == false) {
            System.out.println("\nError:" + errors[2]);
            validated = false;
        }

        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches() == false || phone.startsWith("0") == false) {
            System.out.println("Error: " + errors[3]);
            validated = false;
        }
        if (Integer.parseInt(age) < 0) {
            System.out.println("Error: " + errors[4]);
            validated = false;
        }
        
        return validated;
    }

    public boolean dateValidate(String date) {

        return true;
    }

}
