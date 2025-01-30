import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

class PersonTest {

    @Test
    public void testConstructorAndGetters() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        
        assertEquals("123", person.getID());
        assertEquals("Mr.", person.getTitle());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(1990, person.getYOB());
    }

    @Test
    public void testSetters() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        
        person.setTitle("Dr.");
        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setYOB(1985);

        assertEquals("Dr.", person.getTitle());
        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals(1985, person.getYOB());
    }

    @Test
    public void testFullName() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals((currentYear - 1990) + " years old", person.getAge());
    }

    @Test
    public void testGetAgeInSpecificYear() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("In 2025 you will be 35", person.getAge(2025));
    }

    @Test
    public void testToCSV() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("123, Mr., John, Doe, 1990", person.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("ID : 123, title : Mr., firstName : John, lastName : Doe, YOB : 1990", person.toJSON());
    }

    @Test
    public void testToXML() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("<ID>123</ID> <title>Mr.</title> <firstName>John</firstName> <lastName>Doe</lastName> <YOB>1990</YOB>", person.toXML());
    }

    @Test
    public void testToString() {
        Person person = new Person("123", "Mr.", "John", "Doe", 1990);
        assertEquals("Person{ID='123', title='Mr.', firstName='John', lastName='Doe', YOB=1990}", person.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Person person1 = new Person("123", "Mr.", "John", "Doe", 1990);
        Person person2 = new Person("123", "Mr.", "John", "Doe", 1990);
        Person person3 = new Person("124", "Mr.", "Jane", "Doe", 1992);

        assertEquals(person1, person2); // should be equal
        assertNotEquals(person1, person3); // should not be equal
        assertEquals(person1.hashCode(), person2.hashCode()); // hash codes should be equal
    }
}
