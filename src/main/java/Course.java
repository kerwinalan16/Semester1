import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;

    private static int nextId = 1;

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
        System.out.println("Course: " + courseName + " (" + courseId + ") ");
        System.out.println("\t\t");

        for (Assignment assignment : assignments) {
            System.out.println(assignment.getAssignmentName() + "\t");
        }

        System.out.println("Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.println(student.getStudentName() + "\t");

            for (Assignment assignment : assignments) {
                System.out.println(assignment.getScores().get(i) + "\t\t");
            }

            System.out.println();
        }

        System.out.println("Average\t\t");
        for (Assignment assignment : assignments) {
            System.out.println((int) assignment.calcAssignmentAvg() + "\t\t");
        }
        System.out.println();
    }

}



