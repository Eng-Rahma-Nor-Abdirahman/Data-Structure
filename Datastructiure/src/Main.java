public class Main {
    public static void main(String[] args) {
        // 1. Tijaabada Loan Class
        System.out.println("=== 1. LOAN TEST ===");
        Loan loan = new Loan(2.5, 1, 1000);
        System.out.println("Monthly Payment: $" + String.format("%.2f", loan.getMonthlyPayment()));
        System.out.println("Total Payment: $" + String.format("%.2f", loan.getTotalPayment()));
        System.out.println("Loan Date: " + loan.getLoanDate());

        // 2. Tijaabada BMI Class
        System.out.println("\n=== 2. BMI TEST ===");
        BMI bmi = new BMI("Ahmed", 22, 145, 70);
        System.out.println("Name: " + bmi.getName());
        System.out.println("BMI Value: " + String.format("%.2f", bmi.getBMI()));
        System.out.println("Status: " + bmi.getStatus());

        // 3. Tijaabada Course Class
        System.out.println("\n=== 3. COURSE TEST ===");
        Course course = new Course("Java Programming");
        course.addStudent("Ali");
        course.addStudent("Rahma");
        course.addStudent("Mohamed");

        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Enrolled Students Count: " + course.getNumberOfStudents());
        System.out.print("Students List: ");
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.print(course.getStudents()[i] + (i < course.getNumberOfStudents() - 1 ? ", " : ""));
        }
        System.out.println();
    }
}