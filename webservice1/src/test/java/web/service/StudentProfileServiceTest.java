package web.service;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class StudentProfileServiceTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225167346";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Palakdeep Kaur";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Valid student returns correct name

    @Test
    public void testProfileReturnsCorrectName() {
        StudentProfile profile = StudentProfileService.getStudentProfile("225167346");
        Assert.assertEquals("Palakdeep Kaur", profile.getStudentName());
    }

    // Valid student returns correct status

    @Test
    public void testProfileReturnsCorrectStatus() {
        StudentProfile profile = StudentProfileService.getStudentProfile("225167346");
        Assert.assertEquals("Pass", profile.getStatus());
    }

    // Valid student returns correct number of enrolled units

    @Test
    public void testProfileReturnsCorrectNumberOfUnits() {
        StudentProfile profile = StudentProfileService.getStudentProfile("225167346");
        Assert.assertEquals(4, profile.getEnrolledUnits().size());
    }

    // Valid student returns correct enrolled units

    @Test
    public void testProfileReturnsCorrectUnits() {
        StudentProfile profile = StudentProfileService.getStudentProfile("225167346");
        List<String> units = profile.getEnrolledUnits();
        Assert.assertTrue(units.contains("SIT333"));
        Assert.assertTrue(units.contains("SIT323"));
        Assert.assertTrue(units.contains("SIT374"));
        Assert.assertTrue(units.contains("SIT782"));
    }

    // Unknown student returns null

    @Test
    public void testProfileReturnsNullForUnknownStudent() {
        StudentProfile profile = StudentProfileService.getStudentProfile("999999999");
        Assert.assertNull(profile);
    }

    // Another valid student returns correct status

    @Test
    public void testProfileReturnsFailStatusForAnotherStudent() {
        StudentProfile profile = StudentProfileService.getStudentProfile("000000001");
        Assert.assertEquals("Fail", profile.getStatus());
    }

    // Null student ID throws IllegalArgumentException

    @Test(expected = IllegalArgumentException.class)
    public void testProfileThrowsExceptionForNullStudentId() {
        StudentProfileService.getStudentProfile(null);
    }

    // Empty student ID throws IllegalArgumentException

    @Test(expected = IllegalArgumentException.class)
    public void testProfileThrowsExceptionForEmptyStudentId() {
        StudentProfileService.getStudentProfile("");
    }
}