package GradedExercises;

import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    /** Default constructor */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /** Constructor with specified parameters */
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    // Getters & Setters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    /** Calculate monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        int totalNumberOfPayments = numberOfYears * 12;

        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
    }

    /** Calculate total payment */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    // Main Method
    public static void main(String[] args) {
        Loan loan1 = new Loan();
        System.out.println("--- DEFAULT LOAN ---");
        System.out.println("Monthly Payment: $" + String.format("%.2f", loan1.getMonthlyPayment()));
        System.out.println("Total Payment: $" + String.format("%.2f", loan1.getTotalPayment()));

        Loan loan2 = new Loan(5.5, 3, 5000);
        System.out.println("\n--- CUSTOM LOAN ---");
        System.out.println("Monthly Payment: $" + String.format("%.2f", loan2.getMonthlyPayment()));
        System.out.println("Total Payment: $" + String.format("%.2f", loan2.getTotalPayment()));
        System.out.println("Loan Date: " + loan2.getLoanDate());
    }
}