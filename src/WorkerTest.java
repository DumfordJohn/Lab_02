import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("John", "Doe", "123", "Mr.", 1985);
        worker.setHourlyPayRate(20.0); // Setting hourly pay rate for testing
    }

    @Test
    void testGetHourlyPayRate() {
        assertEquals(20.0, worker.getHourlyPayRate(), "The hourly pay rate should be 20.0");
    }

    @Test
    void testSetHourlyPayRate() {
        worker.setHourlyPayRate(25.0);
        assertEquals(25.0, worker.getHourlyPayRate(), "The hourly pay rate should be updated to 25.0");
    }

    @Test
    void testCalculateWeeklyPay_withRegularHours() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(800.0, pay, "Weekly pay for 40 hours should be $800.00");
    }

    @Test
    void testCalculateWeeklyPay_withOvertime() {
        double pay = worker.calculateWeeklyPay(50);
        assertEquals(800.0, pay, "Weekly pay for 50 hours should be $1000.00");
    }

    @Test
    void testCalculateWeeklyPay_withNoHours() {
        double pay = worker.calculateWeeklyPay(0);
        assertEquals(0.0, pay, "Weekly pay for 0 hours should be $0.00");
    }

    @Test
    void testEquals() {
        Worker anotherWorker = new Worker("John", "Doe", "123", "Mr.", 1985);
        anotherWorker.setHourlyPayRate(20.0);
        assertEquals(worker, anotherWorker, "Workers with the same attributes should be equal");
    }

    @Test
    void testNotEquals_differentHourlyPayRate() {
        Worker anotherWorker = new Worker("John", "Doe", "123", "Mr.", 1985);
        anotherWorker.setHourlyPayRate(30.0);
        assertNotEquals(worker, anotherWorker, "Workers with different pay rates should not be equal");
    }

    @Test
    void testHashCode() {
        Worker anotherWorker = new Worker("John", "Doe", "123", "Mr.", 1985);
        anotherWorker.setHourlyPayRate(20.0);
        assertEquals(worker.hashCode(), anotherWorker.hashCode(), "Workers with the same attributes should have the same hash code");
    }

    @Test
    void testToString() {
        String expectedString = "Worker{Person{ID='123', title='Mr.', firstName='John', lastName='Doe', YOB=1985}hourlyPayRate=20.0}";
        assertEquals(expectedString, worker.toString(), "The toString method should return the correct string representation");
    }

    @Test
    void testTOCSV() {
        String expectedCSV = "123, Mr., John, Doe, 1985, 20.0";
        assertEquals(expectedCSV, worker.toCSV(), "The toCSV method should return the correct string representation");
    }

    @Test
    void testTOJSON() {
        String expectedJSON = "ID : 123, title : Mr., firstName : John, lastName : Doe, YOB : 1985, hourlyPayRate : 20.0";
        assertEquals(expectedJSON, worker.toJSON(), "The toJSON method should return the correct string representation");
    }

    @Test
    void testToXML() {
        String expectedXML = "<ID>123</ID> <title>Mr.</title> <firstName>John</firstName> <lastName>Doe</lastName> <YOB>1985</YOB> <hourlyPayRate>20.0</hourlyPayRate>";
        assertEquals(expectedXML, worker.toXML(), "The toXML method should return the correct string representation");
    }
}
