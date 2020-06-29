package exam.blankQuizeContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class CreateBlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}