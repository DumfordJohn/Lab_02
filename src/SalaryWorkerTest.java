import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {

        @Test
        void testCalculateWeeklyPay() {
            SalaryWorker worker = new SalaryWorker("John", "Doe", "12345", "Software Engineer", 1990, 60000);
            double expectedWeeklyPay = (double) 60000 / 52;
            assertEquals(expectedWeeklyPay, worker.calculateWeeklyPay(0), 1); // Allow for slight rounding differences
        }

        @Test
        void testSetAnnualSalary() {
            SalaryWorker worker = new SalaryWorker("Jane", "Smith", "67890", "Data Analyst", 1985, 55000);
            worker.setAnnualSalary(65000);
            assertEquals(65000, worker.getAnnualSalary());
        }

        @Test
        void testToString() {
            SalaryWorker worker = new SalaryWorker("Alice", "Johnson", "98765", "Project Manager", 1988, 70000);
            String expectedString = "SalaryWorker{Worker{Person{ID='" + worker.getID() + "', title='" + worker.getTitle() + "', firstName='" + worker.getFirstName() + "', lastName='" + worker.getLastName() + "', YOB=" + worker.getYOB() + "}hourlyPayRate=" + worker.getHourlyPayRate() + "}annualSalary=" + worker.getAnnualSalary() + "}";
            assertEquals(expectedString, worker.toString());
        }

        @Test
        void testToCSV() {
            SalaryWorker worker = new SalaryWorker("Bob", "Williams", "101112", "Web Developer", 1992, 50000);
            String expectedCSV = worker.getID() + ", " + worker.getTitle() + ", " + worker.getFirstName() + ", " + worker.getLastName() + ", " + worker.getYOB() + ", " + worker.getHourlyPayRate() + ", " + worker.getAnnualSalary();
            assertEquals(expectedCSV, worker.toCSV());
        }

        @Test
        void testToJSON() {
            SalaryWorker worker = new SalaryWorker("Carol", "Brown", "131415", "UI Designer", 1995, 62000);
            String expectedJSON = "ID : " + worker.getID() + ", title : " + worker.getTitle() + ", firstName : " + worker.getFirstName() + ", lastName : " + worker.getLastName() + ", YOB : "+ worker.getYOB() + ", hourlyPayRate : " + worker.getHourlyPayRate() + ", annualSalary : " + worker.getAnnualSalary();
            assertEquals(expectedJSON, worker.toJSON());
        }

        @Test
        void testToXML() {
            SalaryWorker worker = new SalaryWorker("David", "Davis", "161718", "Database Administrator", 1987, 80000);
            String expectedXML = "<ID>" + worker.getID() + "</ID> <title>" + worker.getTitle() + "</title> <firstName>" + worker.getFirstName() + "</firstName> <lastName>" + worker.getLastName() + "</lastName> <YOB>" + worker.getYOB() + "</YOB> <hourlyPayRate>" + worker.getHourlyPayRate() + "</hourlyPayRate> <annualSalary>" + worker.getAnnualSalary() + "</annualSalary>";
            assertEquals(expectedXML, worker.toXML());
        }

        @Test
        void testEquals() {
            SalaryWorker worker1 = new SalaryWorker("Emily", "Wilson", "192021", "Marketing Manager", 1989, 75000);
            SalaryWorker worker2 = new SalaryWorker("Emily", "Wilson", "192021", "Marketing Manager", 1989, 75000);
            assertTrue(worker1.equals(worker2));

            SalaryWorker worker3 = new SalaryWorker("Emily", "Wilson", "192021", "Marketing Manager", 1989, 70000);
            assertFalse(worker1.equals(worker3));
        }

        @Test
        void testHashCode() {
            SalaryWorker worker1 = new SalaryWorker("Frank", "Garcia", "222324", "Sales Manager", 1991, 68000);
            SalaryWorker worker2 = new SalaryWorker("Frank", "Garcia", "222324", "Sales Manager", 1991, 68000);
            assertEquals(worker1.hashCode(), worker2.hashCode());
        }
    }
