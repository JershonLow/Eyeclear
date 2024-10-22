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
    //    Prescription prescription = new Prescription("addPrescription",
    //    "[name of test]",
    //            "12345678901234567890",
    //            -20.00, -4.00, 0, "21/10/25", "12345678");

    // Testing first name
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

    // Testing last name
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

    // Testing address
    @Test
    public void addPrescriptionTestAddress() {
        // False, address is too short
        Prescription prescription1 = new Prescription("addPrescription",
                "TestAddress1", "1234567890123456789",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True
        Prescription prescription2 = new Prescription("addPrescription",
                "TestAddress2", "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertTrue(prescription2.addPrescription());
    }

    // Testing sphere
    @Test
    public void addPrescriptionTestSphere() {
        // False, sphere exceeds -20.00
        Prescription prescription1 = new Prescription("addPrescription",
                "TestSphere1", "12345678901234567890", -20.001, -4.00, 0,
                "21/10/25", "12345678");

        // False, sphere exceeds 20.00
        Prescription prescription2 = new Prescription("addPrescription",
                "TestSphere2", "12345678901234567890", 20.001, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription3 = new Prescription("addPrescription",
                "TestSphere3", "12345678901234567890", -19.999, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription4 = new Prescription("addPrescription",
                "TestSphere4", "12345678901234567890", 19.999, -4.00, 0,
                "21/10/25", "12345678");

        // True, sphere is within limits
        Prescription prescription5 = new Prescription("addPrescription",
                "TestSphere5", "12345678901234567890", 0, -4.00, 0,
                "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    // Testing cylinder
    @Test
    public void addPrescriptionTestCylinder() {
        // False, cylinder exceeds -4.00
        Prescription prescription1 = new Prescription("addPrescription",
                "TestCylinder1", "12345678901234567890",
                -20.00, -4.001, 0, "21/10/25", "12345678");

        // False, cylinder exceeds 4.00
        Prescription prescription2 = new Prescription("addPrescription",
                "TestCylinder2", "12345678901234567890",
                -20.00, 4.001, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription3 = new Prescription("addPrescription",
                "TestCylinder3", "12345678901234567890",
                -20.00, -3.99, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription4 = new Prescription("addPrescription",
                "TestCylinder4", "12345678901234567890",
                -20.00, 3.99, 0, "21/10/25", "12345678");

        // True, cylinder is within limits
        Prescription prescription5 = new Prescription("addPrescription",
                "TestCylinder5", "12345678901234567890",
                -20.00, 0, 0, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    // Testing axis
    @Test
    public void addPrescriptionTestAxis() {
        // False, axis exceeds 0
        Prescription prescription1 = new Prescription("addPrescription",
                "TestAxis1",
                "12345678901234567890",
                -20.00, -4.00, -0.001, "21/10/25", "12345678");

        // False, axis exceeds 180
        Prescription prescription2 = new Prescription("addPrescription",
                "TestAxis2",
                "12345678901234567890",
                -20.00, -4.00, 180.01, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription3 = new Prescription("addPrescription",
                "TestAxis3",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription4 = new Prescription("addPrescription",
                "TestAxis4",
                "12345678901234567890",
                -20.00, -4.00, 180, "21/10/25", "12345678");

        // True, axis is within limits
        Prescription prescription5 = new Prescription("addPrescription",
                "TestAxis5",
                "12345678901234567890",
                -20.00, -4.00, 90, "21/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    // Testing date
    @Test
    public void addPrescriptionTestDate() {
        // False, day cannot start with 0
        Prescription prescription1 = new Prescription("addPrescription",
                "TestDate1",
                "12345678901234567890",
                -20.00, -4.00, 0, "00/01/25", "12345678");

        // False, date cannot exceed either 30, 31 depending on the month
        Prescription prescription2 = new Prescription("addPrescription",
                "TestDate2",
                "12345678901234567890",
                -20.00, -4.00, 0, "32/01/25", "12345678");

        // False, month cannot exceed 12
        Prescription prescription3 = new Prescription("addPrescription",
                "TestDate3",
                "12345678901234567890",
                -20.00, -4.00, 0, "01/13/25", "12345678");

        // True
        Prescription prescription4 = new Prescription("addPrescription",
                "TestDate4",
                "12345678901234567890",
                -20.00, -4.00, 0, "31/01/24", "12345678");

        // True
        Prescription prescription5 = new Prescription("addPrescription",
                "TestDate5",
                "12345678901234567890",
                -20.00, -4.00, 0, "01/10/25", "12345678");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertFalse(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
        assertTrue(prescription5.addPrescription());
    }

    // Testing optometrist name
    @Test
    public void addPrescriptionTestOptometrist() {
        // False, optometrist name is less than 8 characters
        Prescription prescription1 = new Prescription("addPrescription",
                "Optometrist1",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "1234567");

        // False, optometrist name is longer than 25 characters
        Prescription prescription2 = new Prescription("addPrescription",
                "Optometrist2",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678901234567890123456");

        // True
        Prescription prescription3 = new Prescription("addPrescription",
                "Optometrist3",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True
        Prescription prescription4 = new Prescription("addPrescription",
                "Optometrist4",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "1234567890123456789012345");

        assertFalse(prescription1.addPrescription());
        assertFalse(prescription2.addPrescription());
        assertTrue(prescription3.addPrescription());
        assertTrue(prescription4.addPrescription());
    }
}
