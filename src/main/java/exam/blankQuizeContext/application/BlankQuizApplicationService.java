package exam.blankQuizeContext.application;

import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuiz;
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
        final String teacherId = command.getTeacherId();
        final BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuizId();

        final BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, command.getContent(), command.getReferenceAnswer(), command.getScore());
        blankQuizRepository.save(blankQuiz);

        return blankQuizId;
    }

    public void revise(String blankQuizId, CreateBlankQuizCommand command) {
        final BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));
        blankQuiz.revise(command.getTeacherId(), command.getContent(), command.getReferenceAnswer(), command.getScore());

        blankQuizRepository.save(blankQuiz);
    }

    public void delete(String blankQuizId) {
        final BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));

        blankQuizRepository.remove(blankQuiz);
    }
}
