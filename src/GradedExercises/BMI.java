package GradedExercises;

public class BMI {
    private String name;
    private int age;
    private double weight;
    private double height;

    /** Constructor with all parameters */
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    /** Constructor with default age 20 */
    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    /** Calculate BMI */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /** Determine BMI status */
    public String getStatus() {
        double bmi = getBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Main Method
    public static void main(String[] args) {
        BMI person1 = new BMI("Ali", 22, 145, 70);
        System.out.println("Name: " + person1.getName());
        System.out.println("BMI: " + String.format("%.2f", person1.getBMI()));
        System.out.println("Status: " + person1.getStatus());

        BMI person2 = new BMI("Farhia", 110, 62); // Uses default age 20
        System.out.println("\nName: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("BMI: " + String.format("%.2f", person2.getBMI()));
        System.out.println("Status: " + person2.getStatus());
    }
}