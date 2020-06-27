package exam.blankQuizeContext.userInterface;

import exam.blankQuizeContext.application.BlankQuizApplicationService;
import exam.blankQuizeContext.application.CreateBlankQuizCommand;
import exam.blankQuizeContext.application.PaperApplicationService;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizeContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizeContext.infrastructure.MemoryBlankQuizReadRepository;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.infrastructure.MemoryPaperReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;
    private MemoryBlankQuizReadRepository blankQuizReadRepository;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService, MemoryBlankQuizReadRepository blankQuizReadRepository) {
        this.blankQuizApplicationService = blankQuizApplicationService;
        this.blankQuizReadRepository = blankQuizReadRepository;
    }

    @PostMapping("/blankQuizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizId create(@RequestBody CreateBlankQuizCommand command) {
        return blankQuizApplicationService.create(command);
    }

    @GetMapping("/blankQuizzes") //读请求,获取倒序排列的BlankQuiz
    List<BlankQuiz> getAll() {
        return blankQuizReadRepository.getAllByReversedOrder();
    }

    @PutMapping("/blankQuiz/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable String blankQuizId, @RequestBody CreateBlankQuizCommand command) {
        blankQuizApplicationService.update(blankQuizId, command);
    }
}
