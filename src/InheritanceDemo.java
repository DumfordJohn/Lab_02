import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create workers
        workers.add(new Worker("John", "Dumford", "101", "Mr.", 2001));
        workers.add(new Worker("Adam", "Dumford", "102", "Mr.", 2003));
        workers.add(new Worker("Eric", "Dumford", "103", "Mr.", 2006));
        workers.add(new SalaryWorker("Meghan", "Mozzone", "201", "Mrs.", 2002, 60000.00));
        workers.add(new SalaryWorker("Amy", "Dumford", "202", "Mrs.", 1970, 75000.00));
        workers.add(new SalaryWorker("Brian", "Dumford", "203", "Mr.", 1972, 80000.00));

        // Simulate weekly pay periods
        int[] hoursWorked = {40, 50, 40}; // Hours worked for each week

        System.out.println("--------------------------------------------------");
        System.out.println("Weekly Pay Report");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s\t%-5s\t%-8s\t%-8s\t%-8s\n", "Name", "ID", "Week 1", "Week 2", "Week 3");
        System.out.println("--------------------------------------------------");

        for (Worker worker : workers) {
            System.out.printf("%-10s\t%-5s\t", worker.getFullName(), worker.getID());
            for (int j : hoursWorked) {
                double weeklyPay = 0;
                weeklyPay = ((Worker) worker).calculateWeeklyPay(j);
                System.out.printf("%-8.2f\t", weeklyPay);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
}
