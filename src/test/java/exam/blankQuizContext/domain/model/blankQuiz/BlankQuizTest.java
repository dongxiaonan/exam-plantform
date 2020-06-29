package exam.blankQuizContext.domain.model.blankQuiz;

import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {
    private BlankQuizId blankQuizId = new BlankQuizId("blank_quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");

    @Test
    public void should_create_blank_quiz_with_new() {
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final String content = "1 + 1 = ";
        final String referenceAnswer = "2";
        final int score  = 5;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, content, referenceAnswer, score);

        assertThat(blankQuiz, is(notNullValue()));

        assertThat(blankQuiz.getBlankQuizId(), is(blankQuizId));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getContent(), is("1 + 1 = "));
        assertThat(blankQuiz.getUpdateTime(), nullValue());
    }

    @Test
    public void should_update_blank_quiz() {
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final String content = "1 + 1 = ";
        final String referenceAnswer = "2";
        final int score  = 5;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, content, referenceAnswer, score);

        blankQuiz.revise(teacherId, content, referenceAnswer, 10);
        assertThat(blankQuiz, is(notNullValue()));

        assertThat(blankQuiz.getBlankQuizId(), is(blankQuizId));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getScore(), is(10));
        assertThat(blankQuiz.getUpdateTime(), instanceOf(LocalDateTime.class));
    }
}
