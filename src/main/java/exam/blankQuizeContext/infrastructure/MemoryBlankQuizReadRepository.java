package exam.blankQuizeContext.infrastructure;

import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryBlankQuizReadRepository {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public MemoryBlankQuizReadRepository(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }


    public List<BlankQuiz> getAllByReversedOrder() {
        return blankQuizRepository.getAll();
    }
}
