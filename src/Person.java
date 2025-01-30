import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String ID = "";
    private String title = "";
    private String firstName = "";
    private String lastName = "";
    private int YOB = 0;

    public Person(String ID, String title, String firstName, String lastName, int YOB) {
        this.ID = ID;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }

    public String formalName(){
        return title + " " + fullName();
    }

    public String getAge(){
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int age = currentYear - YOB;
        return age + " years old";
    }

    public String getAge(int year){
        Calendar cal = Calendar.getInstance();
        int specificAge = year - YOB;
        return "In " + year + " you will be " + specificAge;
    }

    public String toCSV(){
        return ID + ", " + title + ", " + firstName + ", " + lastName + ", " + YOB;
    }

    public String toJSON(){
        return "ID : " + ID + ", title : " + title + ", firstName : " + firstName + ", lastName : " + lastName + ", YOB : " + YOB;
    }

    public String toXML(){
        return "<ID>" + ID + "</ID> " + "<title>" + title + "</title> " + "<firstName>" + firstName + "</firstName> " + "<lastName>" + lastName + "</lastName> " + "<YOB>" + YOB + "</YOB>";
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(title, person.title) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, title, firstName, lastName, YOB);
    }
}
