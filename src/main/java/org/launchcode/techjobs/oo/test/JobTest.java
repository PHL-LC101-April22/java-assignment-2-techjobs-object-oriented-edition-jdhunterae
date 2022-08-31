package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job = new Job("Product tester", employer, location, positionType, coreCompetency);

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals(employer.toString(), job.getEmployer().toString());
        assertEquals(location.toString(), job.getLocation().toString());
        assertEquals(positionType.toString(), job.getPositionType().toString());
        assertEquals(coreCompetency.toString(), job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job1 = new Job("Product tester", employer, location, positionType, coreCompetency);
        Job job2 = new Job("Product tester", employer, location, positionType, coreCompetency);

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobsForIdOnlyToString() {
        Job job = new Job();

        assertEquals(job.toString(), "OOPS! This job does not seem to exist.");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        job.setName("Product tester");
        String display = job.toString();

        String builder = "\nID: " + job.getId() +"\n";
        builder += "Name: Product tester\n";
        builder += "Employer: Data not available\n";
        builder += "Location: Data not available\n";
        builder += "Position: Data not available\n";
        builder += "Core Competency: Data not available\n";

        assertEquals(display.charAt(0), builder.charAt(0));
        assertEquals(display.charAt(display.length()-1), builder.charAt(builder.length()-1));
    }

    @Test
    public void testJobsToStringContainsAllLabels() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job = new Job("Product tester", employer, location, positionType, coreCompetency);
        String display = job.toString();

        assertTrue(display.contains("ID:"));
        assertTrue(display.contains("Name:"));
        assertTrue(display.contains("Employer:"));
        assertTrue(display.contains("Location:"));
        assertTrue(display.contains("Position Type:"));
        assertTrue(display.contains("Core Competency:"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job();
        job.setName("Product tester");
        String display = job.toString();

        String builder = "\nID: " + job.getId() +"\n";
        builder += "Name: Product tester\n";
        builder += "Employer: Data not available\n";
        builder += "Location: Data not available\n";
        builder += "Position: Data not available\n";
        builder += "Core Competency: Data not available\n";

        assertTrue(display.contains("ID: " + job.getId()));
        assertTrue(display.contains("Name: Product tester"));
        assertTrue(display.contains("Employer: Data not available"));
        assertTrue(display.contains("Location: Data not available"));
        assertTrue(display.contains("Position Type: Data not available"));
        assertTrue(display.contains("Core Competency: Data not available"));

        assertEquals(display, builder);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job = new Job("Product tester", employer, location, positionType, coreCompetency);
        String display = job.toString();

        String builder = "\nID: " + job.getId() +"\n";
        builder += "Name: Product tester\n";
        builder += "Employer: ACME\n";
        builder += "Location: Desert\n";
        builder += "Position: Quality control\n";
        builder += "Core Competency: Persistence\n";

        assertEquals(display, builder);

        assertTrue(display.contains("ID: " + job.getId()));
        assertTrue(display.contains("Name: Product tester"));
        assertTrue(display.contains("Employer: ACME"));
        assertTrue(display.contains("Location: Desert"));
        assertTrue(display.contains("Position Type: Quality control"));
        assertTrue(display.contains("Core Competency: Persistence"));
    }
}
