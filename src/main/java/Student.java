import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@EqualsAndHashCode
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();

    }
    public enum Gender{
        Male, Female
    }

    /**
     * Registers a course for this student.
     * 1) Adds the course to the student's registeredCourses list.
     * 2) Adds this student to the course's registeredStudents list.
     * 3) Appends a null for the scores of each assignment of the course.
     * @param course the course to register
     * @return true if registration succeeded, false if already registeredad
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);


        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * Drops a course for this student
     * 1) Removes the course from the student's registeredCourses list
     * 2) Removes this student from the course's registeredStudents list
     * @param course the course to drop
     * @return true if drop succeeded, false if the course was not registered
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }












    }
