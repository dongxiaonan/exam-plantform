package exam.blankQuizeContext.domain.model.blankQuiz;

import exam.shared.Entity;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private LocalDateTime createTime;

    private BlankQuiz(BlankQuizId blankQuizId, String teacherId) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        createTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId) {
        return new BlankQuiz(blankQuizId, teacherId);
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }

    public BlankQuizId getBlankQuizId() {
        return blankQuizId;
    }
}
