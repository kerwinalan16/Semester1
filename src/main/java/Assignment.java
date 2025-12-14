import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
   @Getter private String assignmentName;
   @Getter private double weight;
    @Getter private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = String.format("%03d", nextId++);
    }
    /**
     * Calculates the average score of this assignment.
     * Null scores are ignored when calculating the average.
     * If scores = [90, null, 80], the average = (90 + 80) / 2 = 85.
     * @return the average of non-null scores, or 0 if there are no scores or all scores are null
     */
    public double calcAssignmentAvg() {
        if (scores.isEmpty()) return 0;
        double sum = 0;
        for (Integer score : scores) {
            if (score != null) sum += score;
        }
        return sum / scores.size();
    }

    /**
     * Generates random scores for all students in this assignment according to the following rules:
     * Generate a random number r in the range [0, 10].
     * If r == 0, generate a score in the range [0, 60).
     * If r == 1 or 2, generate a score in the range [60, 70).
     * If r == 3 or 4, generate a score in the range [70, 80).
     * If r >= 5 and <= 8, generate a score in the range [80, 90).
     * If r == 9 or 10, generate a score in the range [90, 100].
     */
    public void generateRandomScore() {
        Random random = new Random();
        List<Integer> newScores = new ArrayList<>();

        for (int i = 0; i < scores.size(); i++) {
            int r = random.nextInt(11);
            int score;

            if (r == 0) {
                score = random.nextInt(60);
            } else if (r == 1 || r == 2) {
                score = 60 + random.nextInt(10);
            } else if (r == 3 || r == 4) {
                score = 70 + random.nextInt(10);
            } else if (r >= 5 && r <= 8) {
                score = 80 + random.nextInt(10);
            } else {
                score = 90 + random.nextInt(11);
            }

            newScores.add(score);
        }

    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight='" + weight + '\'' +
                ", scores=" + scores +
                '}';
    }
}
