import org.eyeclear.Prescription;
import org.junit.Test;

import static org.junit.Assert.*;

public class addPrescriptionTest {
    // Prescription test default values:
    // First name = 1234 (test minimum 4 characters)
    // Last name = 123456789012345 (test maximum 15 characters)
    // Address =  12345678901234567890 (test minimum 20 characters)
    // Sphere = -20.00
    // Cylinder = -4.00
    // Axis = 0
    // Date = 21/10/25
    // Optometrist = 12345678 (test minimum 8 characters)
    //
    // Prescription default:
    //    Prescription prescription = new Prescription("1234",
    //    "123456789012345",
    //            "12345678901234567890",
    //            -20.00, -4.00, 0, "21/10/25", "12345678");

    @Test
    public void addPrescriptionTestNameTooShort() {
        // False, first name is too short
        Prescription prescription1 = new Prescription("123", "123456789012345"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        // False, first name is too long
        Prescription prescription2 = new Prescription("1234567890123456",
                "123456789012345"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        // True
        Prescription prescription3 = new Prescription("123456789012345",
                "123456789012345"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        // True
        Prescription prescription4 = new Prescription("1234", "123456789012345"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
    }

    @Test
    public void addPrescriptionTestLastName() {
        // False, last name is too short
        Prescription prescription1 = new Prescription("1234",
                "123"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        // False, last name is too long
        Prescription prescription2 = new Prescription("1234",
                "1234567890123456"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");


        // True, testing first name and last name boundary
        Prescription prescription3 = new Prescription("1234", "1234"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        // True, testing first name and last name boundary
        Prescription prescription4 = new Prescription("1234",
                "123456789012345"
                , "12345678901234567890", -20.00, -4.00
                , 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
    }

    @Test
    public void addPrescriptionTestAddress() {
        // False, address is too short
        Prescription prescription1 = new Prescription("1234",
                "123456789012345", "1234567890123456789",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True
        Prescription prescription2 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertTrue(prescription2.addPrescription());
    }

    @Test
    public void addPrescriptionTestSphere() {
        // False, sphere exceeds -20.00
        Prescription prescription1 = new Prescription("1234",
                "123456789012345", "12345678901234567890", -20.001, -4.00, 0,
                "21/10/25", "12345678");

        // False, sphere exceeds 20.00
        Prescription prescription2 = new Prescription("1234",
                "123456789012345", "12345678901234567890", 20.001, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription3 = new Prescription("1234",
                "123456789012345", "12345678901234567890", -19.999, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription4 = new Prescription("1234",
                "123456789012345", "12345678901234567890", 19.999, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription5 = new Prescription("1234",
                "123456789012345", "12345678901234567890", 0, -4.00, 0,
                "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    @Test
    public void addPrescriptionTestCylinder() {
        // False, cylinder exceeds -4.00
        Prescription prescription1 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, -4.001, 0, "21/10/25", "12345678");

        // False, cylinder exceeds 4.00
        Prescription prescription2 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, 4.001, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription3 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, -3.99, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription4 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, 3.99, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription5 = new Prescription("1234",
                "123456789012345", "12345678901234567890",
                -20.00, 0, 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    @Test
    public void addPrescriptionTestAxis() {
        // False, axis exceeds 0
        Prescription prescription1 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, -0.001, "21/10/25", "12345678");

        // False, axis exceeds 180
        Prescription prescription2 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 180.01, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription3 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription4 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 180, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription5 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 90, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    @Test
    public void addPrescriptionTestDate() {
        // False, day cannot start with 00
        Prescription prescription1 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "00/13/25", "12345678");

        // False, date cannot exceed either 30, 31
        Prescription prescription2 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "35/1/25", "12345678");

        // False, year must be 2 digits
        Prescription prescription3 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "35/1/254", "12345678");

        // True
        Prescription prescription4 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "31/01/24", "12345678");

        // True
        Prescription prescription5 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "1/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertFalse(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    @Test
    public void addPrescriptionTestOptometrist() {
        // False, optometrist name is less than 8 characters
        Prescription prescription1 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "1234567");

        // False, optometrist name is longer than 25 characters
        Prescription prescription2 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678901234567890123456");

        // True
        Prescription prescription3 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True
        Prescription prescription4 = new Prescription("1234", "123456789012345",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "1234567890123456789012345");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
    }
}
