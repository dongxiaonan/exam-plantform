package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<Quiz> quizzes;

    public String getTeacherId() {
        return teacherId;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @Value
    public static class Quiz {
        private String quizId;
        private int score;

        public int getScore() {
            return score;
        }

        public String getQuizId() {
            return quizId;
        }
    }
}