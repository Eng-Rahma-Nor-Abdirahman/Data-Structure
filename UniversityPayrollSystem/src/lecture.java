
import java.util.ArrayList;
import java.util.List;

public abstract class lecture {
    private String lectureId;
    private String name;

    lecture(String lectureId, String name) {
        this.lectureId = lectureId;
        this.name = name;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String id) {
        this.lectureId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract methods
    public abstract double calculateSalary();
    public abstract void displayInformation();
}

class fullTimeLecture extends lecture {
    private double basicSalary;
    private double researchAllowance;
    private double administrativeAllowance;

    fullTimeLecture(String lectureId, String name, double basicSalary,
                    double researchAllowance, double administrativeAllowance) {
        super(lectureId, name);
        this.basicSalary = basicSalary;
        this.researchAllowance = researchAllowance;
        this.administrativeAllowance = administrativeAllowance;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getResearchAllowance() {
        return researchAllowance;
    }

    public void setResearchAllowance(double researchAllowance) {
        this.researchAllowance = researchAllowance;
    }

    public double getAdministrativeAllowance() {
        return administrativeAllowance;
    }

    public void setAdministrativeAllowance(double administrativeAllowance) {
        this.administrativeAllowance = administrativeAllowance;
    }

    @Override
    public double calculateSalary() {
        double salary = basicSalary + researchAllowance + administrativeAllowance;
        return salary;
    }

    @Override
    public void displayInformation() {
        System.out.println("Name: " + getName());
        System.out.println("Lecture ID: " + getLectureId());
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Research Allowance: " + researchAllowance);
        System.out.println("Administrative Allowance: " + administrativeAllowance);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class partTimeLecture extends lecture {
    private double teachingHours;
    private double hourlyRate;

    partTimeLecture(String name, String lectureId, double teachingHours, double hourlyRate) {
        super(lectureId, name);
        this.teachingHours = teachingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(double teachingHours) {
        this.teachingHours = teachingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        double salary = teachingHours * hourlyRate;
        return salary;
    }

    @Override
    public void displayInformation() {
        System.out.println("Name: " + getName());
        System.out.println("Lecture ID: " + getLectureId());
        System.out.println("Teaching Hours: " + teachingHours);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class UniversityPayrollSystem {
    private List<lecture> lecturers = new ArrayList<>();

    public void addLecturer(lecture lecturer) {
        lecturers.add(lecturer);
    }

    public void displayAllLecturers() {
        for (lecture l : lecturers) {
            l.displayInformation();
            System.out.println();
        }
    }

    public void displayHighestPaidLecturer() {
        if (lecturers.isEmpty()) return;

        lecture highest = lecturers.get(0);

        for (lecture l : lecturers) {
            if (l.calculateSalary() > highest.calculateSalary()) {
                highest = l;
            }
        }

        System.out.println("\n--- Highest Paid Lecturer ---");
        highest.displayInformation();
    }
}

class main {
    public static void main(String[] args) {

        // fullTimeLecturer object
        fullTimeLecture full1 = new fullTimeLecture("Rahma", "c1240259", 200, 2, 3);

        System.out.println("Name: " + full1.getName());
        System.out.println("Lecture ID: " + full1.getLectureId());
        System.out.println("Basic Salary: " + full1.getBasicSalary());
        System.out.println("Research Allowance: " + full1.getResearchAllowance());
        System.out.println("Administrative Allowance: " + full1.getAdministrativeAllowance());

        fullTimeLecture full2 = new fullTimeLecture("ENGRimaa", "c1240", 1500, 4, 3);

        System.out.println("\nName: " + full2.getName());
        System.out.println("Lecture ID: " + full2.getLectureId());
        System.out.println("Basic Salary: " + full2.getBasicSalary());
        System.out.println("Research Allowance: " + full2.getResearchAllowance());
        System.out.println("Administrative Allowance: " + full2.getAdministrativeAllowance());

        // partTimeLecturer object
        partTimeLecture part1 = new partTimeLecture("Eng Sheub", "ca123", 3, 2.5);

        System.out.println("\nName: " + part1.getName());
        System.out.println("Lecture ID: " + part1.getLectureId());
        System.out.println("Teaching Hours: " + part1.getTeachingHours());
        System.out.println("Hourly Rate: " + part1.getHourlyRate());

        partTimeLecture part2 = new partTimeLecture("Eng adna", "ca145", 5, 6.6);

        System.out.println("\nName: " + part2.getName());
        System.out.println("Lecture ID: " + part2.getLectureId());
        System.out.println("Teaching Hours: " + part2.getTeachingHours());
        System.out.println("Hourly Rate: " + part2.getHourlyRate());

        partTimeLecture part3 = new partTimeLecture("Eng Yahya", "ca1477", 5, 6.6);

        System.out.println("\nName: " + part3.getName());
        System.out.println("Lecture ID: " + part3.getLectureId());
        System.out.println("Teaching Hours: " + part3.getTeachingHours());
        System.out.println("Hourly Rate: " + part3.getHourlyRate());


          //university object
        UniversityPayrollSystem payroll = new UniversityPayrollSystem();

        payroll.addLecturer(full1);
        payroll.addLecturer(full2);
        payroll.addLecturer(part1);
        payroll.addLecturer(part2);
        payroll.addLecturer(part3);

           // Display all lecturers
        System.out.println("\n--- All Lecturers ---");
        payroll.displayAllLecturers();

         // Display highest-paid lecturer
        payroll.displayHighestPaidLecturer();
    }
}
