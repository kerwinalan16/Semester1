import java.util.ArrayList;
import java.util.List;

public class Assignment {
    public String assignmentId;
    public String assignmentName;
    public double weight;
    public List<Integer> scores;
    public static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = String.format("%03d", nextId++);
    }
}
