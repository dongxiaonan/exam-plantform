package exam.blankQuizeContext.infrastructure;

import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream().filter(blankQuiz-> {
            return blankQuiz.getBlankQuizId().equals(blankQuizId);
        }).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.add(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return blankQuizzes.stream().collect(Collectors.toList());
    }
}
