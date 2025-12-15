import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     checks if the sum of weights of all assignments of that course equals to 100%
     @return true if the sum of weights of all assignments of that course equals to 100%, false if not
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;

        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }

        return totalWeight == 100;
    }
    /**
     adds a student to the student list of the course
     adds a new null element to each assignment of this course,
     adds a new null element for the finalScores
     @param student the givem student
     @return true if the student has been registered to this course, false if not
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * Calculates the average score of this assignment.
     * Null scores are ignored when calculating the average.
     * Example:
     * If scores = [90, null, 80], the average = (90 + 80) / 2 = 85.
     * @return the average of non-null scores, or 0 if there are no scores or all scores are null
     */
    public int[] calcStudentsAvg() {
        int[] avgs = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    sum += (score * assignment.getWeight()) / 100;
                }
            }

            avgs[i] = (int) sum;
        }

        return avgs;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the name of the assignment added
     * @param weight the weight of the assignment added
     * @return true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        assignments.add(assignment);

        return true;
    }

    /**
     * generates random scores for each assignment and student,
     * calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i); // null-safe check
                if (score != null) {
                    sum += (score * assignment.getWeight()) / 100.0;
                }
            }
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.println("Course: " + Util.toTitleCase(courseName) + " (" + courseId + ") ");

        System.out.printf("%-25s", "");
        for (Assignment assignment: assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
            System.out.printf("%-15s%n", "Final Score");
            int[] finalScores = calcStudentsAvg();

            for (int i = 0; 1 < registeredStudents.size(); i++) {
                Student student = registeredStudents.get(i);

                System.out.printf("%-25s", student.getStudentName());
                for (Assignment assignment : assignments) {
                    Integer score = assignment.getScores().get(i);
                    System.out.printf("%-15s", score == null ? "-" : score);
                }
                System.out.printf("%-15s%n", finalScores[i]);
            }
                System.out.printf("%-25s", "Average");
                System.out.println();
                for (Assignment assignment: assignments) {
                    System.out.printf("%-15d", (int) assignment.calcAssignmentAvg());
                    System.out.println();
                }
        System.out.println();
    }

    /**
     * converts a course to a simple string with only the courseId, the courseName, the credits, and departmentName
     * @return the simplifiedString
     */
    public String toSimplifiedString() {
        return "Course ID: " + courseId +
                "Course Name: " + courseName +
                "Credits: " + credits +
                "Department Name: " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String toStringCourse = "";
        toStringCourse += "Course ID: " + courseId + "\n";
        toStringCourse += "Course Name: " + courseName + "\n";
        toStringCourse += "Credits: " + credits + "\n";
        toStringCourse += "Department: " + department.getDepartmentName()+ "\n";

        toStringCourse += "Assignments:\n";
        for (Assignment assignment : assignments) {
            toStringCourse += " " + assignment + "\n";
        }

        toStringCourse += "Registered Students: \n";
        for (Student student : registeredStudents) {
            toStringCourse += " " +
                    "Student ID: " + student.getStudentId() + "\n" +
                    "Student Name: " + student.getStudentName() + "\n" +
                    "Department: " + student.getDepartment().getDepartmentName() + "\n";
        }

        toStringCourse += "Assignment Weight Valid" + isAssignmentWeightValid();
        return toStringCourse;
    }

}



