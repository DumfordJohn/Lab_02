import java.util.Objects;

public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB) {
        super(ID, title, firstName, lastName, YOB);
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked){
        final int standardHours = 40;

        double normalHours = Math.min(hoursWorked, standardHours);
        double overtimeHours = Math.max(0, normalHours - standardHours);

        double weeklyPay = normalHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;

        return weeklyPay + overtimePay;
    }

    public void displayWeeklyPay(double hoursWorked){
        final int standardHours = 40;

        double normalHours = Math.min(hoursWorked, standardHours);
        double overtimeHours = Math.max(0, normalHours - standardHours);

        double weeklyPay = normalHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = weeklyPay + overtimePay;

        System.out.printf("Regular Hours: %.1f @ $%.2f = $%.2f%n", normalHours, hourlyPayRate, weeklyPay);
        System.out.printf("Overtime Hours: %.1f @ $%.2f = $%.2f%n", overtimeHours, hourlyPayRate * 1.5, overtimePay);
        System.out.printf("Total Combined Pay: $%.2f%n", totalPay);
    }

    @Override
    public String toString() {
        return "Worker{" + super.toString() +
                "hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return super.toJSON() + ", hourlyPayRate : " + hourlyPayRate;
    }

    @Override
    public String toXML() {
        return super.toXML() + " <hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(hourlyPayRate, worker.hourlyPayRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyPayRate);
    }
}
