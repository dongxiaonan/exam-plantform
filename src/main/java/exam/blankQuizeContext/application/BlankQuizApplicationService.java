package exam.blankQuizeContext.application;

import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizRepository;
import exam.paperContext.domain.service.BlankQuizClient;
import exam.paperContext.domain.service.BlankQuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;
    private BlankQuizClient blankQuizClient;

    private List<BlankQuizDto> getBlankQuizzesByIds(List<String> blankQuizIds) {
        return blankQuizClient.getBlankQuizzesByIds(blankQuizIds);
    }

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(CreateBlankQuizCommand command) {
        return null;
    }
}
