import java.util.Objects;

public class SalaryWorker extends Worker{
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double annualSalary) {
        super(firstName, lastName, ID, title, YOB);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return Math.round(annualSalary / 52 * 100.0) / 100.0;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.printf("Your weekly pay is $%.2f, which is a fraction of your annual salary of $%.2f.%n", calculateWeeklyPay(hoursWorked), annualSalary);
    }

    @Override
    public String toString() {
        return "SalaryWorker{" + super.toString() +
                "annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public String toCSV(){
        return super.toCSV() + ", " + annualSalary;
    }

    @Override
    public String toJSON(){
        return super.toJSON() + ", annualSalary : " + annualSalary;
    }

    @Override
    public String toXML(){
        return super.toXML() + " <annualSalary>" + annualSalary + "</annualSalary>";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalaryWorker that = (SalaryWorker) o;
        return Double.compare(annualSalary, that.annualSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }
}
