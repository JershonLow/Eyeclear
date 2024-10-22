import org.eyeclear.Prescription;
import org.junit.Test;

import static org.junit.Assert.*;

public class addRemarkTest {
    // Default prescription
    //    Prescription prescription = new Prescription("addRemarkTest",
    //    "[name of test]]",
    //            "12345678901234567890",
    //            -20.00, -4.00, 0, "21/10/25", "12345678");

    // Testing lower boundary of word limit
    @Test
    public void addRemarkTestRemarkTooFewWords() {
        Prescription prescription = new Prescription("addRemarkTest",
                "TooFewWords",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // False, minimum number of words is 6
        assertFalse(prescription.addRemark("One two three four five", "client"
        ));

        // True
        assertTrue(prescription.addRemark("One two three four five six",
                "client"));
    }

    // Testing upper boundary of word limit
    @Test
    public void addRemarkTestRemarkTooManyWords() {
        Prescription prescription = new Prescription("addRemarkTest",
                "TooManyWords",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // False, minimum number of words is 20
        assertFalse(prescription.addRemark("One two three four five six " +
                        "seven" +
                        " eight nine ten eleven twelve thirteen fourteen " +
                        "fifteen " +
                        "sixteen seventeen eighteen nineteen twenty twentyOne",
                "client"));

        // True
        assertTrue(prescription.addRemark("One two three four five six seven" +
                        " eight nine ten eleven twelve thirteen fourteen " +
                        "fifteen " +
                        "sixteen seventeen eighteen nineteen twenty",
                "client"));
    }

    // Testing first character of first word uppercase
    @Test
    public void addRemarkTestRemarkUppercase() {
        Prescription prescription = new Prescription("addRemarkTest",
                "Uppercase",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // False, first word should be capital
        assertFalse(prescription.addRemark("one two three four five six",
                "client"));

        // True
        assertTrue((prescription.addRemark("One two three four five six",
                "client")));
    }

    // Testing remark type optometrist
    @Test
    public void addRemarkTestRemarkTypeOptometrist() {
        Prescription prescription = new Prescription("addRemarkTest",
                "Optometrist",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // False, should be "optometrist"
        assertFalse(prescription.addRemark("one two three four five six",
                "Optometrist"));

        // True
        assertFalse(prescription.addRemark("one two three four five six",
                "optometrist"));
    }

    //Testing remark type client
    @Test
    public void addRemarkTestRemarkTypeClient() {
        Prescription prescription = new Prescription("addRemarkTest", "Client",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // False, should be "client"
        assertFalse(prescription.addRemark("one two three four five six",
                "Client"));

        // True
        assertFalse(prescription.addRemark("one two three four five six",
                "client"));
    }

    //Testing number of remarks under a prescription.
    @Test
    public void addRemarkTestRemarkNumber() {
        Prescription prescription = new Prescription("addRemarkTest",
                "RemarkNumber",
                "12345678901234567890",
                -20.00, -4.00, 0, "21/10/25", "12345678");

        // True, first remark
        assertTrue(prescription.addRemark("One two three four five six",
                "client"));

        // True, second remark
        assertTrue(prescription.addRemark("One two three four five six seven",
                "optometrist"));

        // False, third remark
        assertFalse(prescription.addRemark("One two three four five six eight",
                "optometrist"));
    }
}
