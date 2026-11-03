package GradedExercises;

public class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    /** Constructor */
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[10];
        this.numberOfStudents = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                break;
            }
        }
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    // Main Method
    public static void main(String[] args) {
        Course course = new Course("Java Programming");

        // Add students
        course.addStudent("Rahma");
        course.addStudent("Ahmed");
        course.addStudent("Mohamed");

        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Number of Students: " + course.getNumberOfStudents());

        // Drop a student
        System.out.println("\nDropping 'Ahmed'...");
        course.dropStudent("Ahmed");

        System.out.println("Number of Students Now: " + course.getNumberOfStudents());
        System.out.print("Remaining Students: ");
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.print(course.getStudents()[i] + (i < course.getNumberOfStudents() - 1 ? ", " : ""));
        }
        System.out.println();
    }
}