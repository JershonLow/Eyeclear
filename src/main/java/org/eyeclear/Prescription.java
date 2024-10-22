package org.eyeclear;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private double sphere;
    private double cylinder;
    private double axis;
    private String inputDate;
    private String optometrist;
    private ArrayList<String> postRemarks = new ArrayList<>();

    // Constructor
    public Prescription(String firstName, String lastName, String address,
                        double sphere, double cylinder, double axis,
                        String inputDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.inputDate = inputDate;
        this.optometrist = optometrist;
    }

    // Validates the date format
    private boolean validateDate(String inputDate) {
        SimpleDateFormat dateValidation = new SimpleDateFormat("dd/MM/yy");
        dateValidation.setLenient(false);

        try {
            dateValidation.parse(inputDate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    public boolean addPrescription() {
        if (firstName.length() < 4 || firstName.length() > 15) {
            System.out.println("ERROR: First name should have a minimum of 4 " +
                    "characters and a maximum of 15 characters.");
            return false;
        } else if (lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("ERROR: Last name should have a minimum of 4 " +
                    "characters and a maximum of 15 characters.");
            return false;
        } else if (address.length() < 20) {
            System.out.println("ERROR: Address should have a minimum of 20 " +
                    "characters.");
            return false;
        } else if (sphere < -20.00 || sphere > 20.00) {
            System.out.println("ERROR: Spherical correction value should only" +
                    " have a range from -20.00 to +20.00.");
            return false;
        } else if (cylinder < -4.00 || cylinder > 4.00) {
            System.out.println("ERROR: Cylinder value should only have a " +
                    "range from -4.00 to +4.00.");
            return false;
        } else if (axis < 0 || axis > 180) {
            System.out.println("ERROR: Axis should only have a range between " +
                    "0 to 180.");
            return false;
        } else if (!validateDate(inputDate)) {
            System.out.println("ERROR: Date input invalid");
            return false;
        } else if (optometrist.length() < 8 || optometrist.length() > 25) {
            System.out.println("ERROR: Optometrist name should have a minimum" +
                    " of 8 characters and a maximum of 25 characters.");
            return false;
        }

        String prescriptionFileName =
                "Prescription - " + firstName + " " + lastName + ".txt";
        try (FileWriter prescriptionWriter =
                     new FileWriter(prescriptionFileName)) {
            prescriptionWriter.write("First Name: " + firstName + "\n");
            prescriptionWriter.write("Last Name: " + lastName + "\n");
            prescriptionWriter.write("Address: " + address + "\n");
            prescriptionWriter.write("Sphere: " + sphere + "\n");
            prescriptionWriter.write("Cylinder: " + cylinder + "\n");
            prescriptionWriter.write("Axis: " + axis + "\n");
            prescriptionWriter.write("Date: " + inputDate + "\n");
            prescriptionWriter.write("Optometrist: " + optometrist + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean addRemark(String remark, String remarkType) {
        if (postRemarks.size() >= 2) {
            System.out.println("ERROR: Cannot add more than 2 remarks in a " +
                    "prescription.");
            return false;
        } else if (remark.trim().split("\\s+").length < 6 || remark.trim().split("\\s+").length > 20) {
            System.out.println("ERROR: Remark should have a minimum of 6 " +
                    "words and a maximum of 20 words.");
            return false;
        } else if (!Character.isUpperCase(remark.charAt(0))) {
            System.out.println("ERROR: First word in remark should be " +
                    "uppercase");
            return false;
        } else if (!remarkType.equals("client") && !remarkType.equals(
                "optometrist")) {
            System.out.println("ERROR: Remark type should be either " +
                    "\"client\" or \"optometrist\"");
            return false;
        }

        String remarkFileName = "Review - " + firstName + " " + lastName + " " +
                "- " + (postRemarks.size() + 1) + ".txt";

        try (FileWriter remarkWriter = new FileWriter(remarkFileName)) {
            String remarkWriterStr = "Remark Type: " + remarkType + "\nRemark" +
                    ": " + remark;
            remarkWriter.write(remarkWriterStr);
            postRemarks.add(remarkWriterStr);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
