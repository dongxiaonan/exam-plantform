package exam.blankQuizeContext.domain.model.blankQuiz;

import exam.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.PrimitiveIterator;

@EqualsAndHashCode(of = {"blankQuizId"})
@Getter
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private LocalDateTime createTime;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime updateTime;

    private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        createTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score);
    }

    public void revise(String teacherId, String content, String referenceAnswer, int score){
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.updateTime = LocalDateTime.now();
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }

    public BlankQuizId getBlankQuizId() {
        return blankQuizId;
    }
}
