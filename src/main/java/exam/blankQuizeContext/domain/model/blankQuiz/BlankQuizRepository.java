package exam.blankQuizeContext.domain.model.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    void remove(BlankQuiz blankQuiz);

    List<BlankQuiz> getAll();

    BlankQuizId nextBlankQuizId();
}
