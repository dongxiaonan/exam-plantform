package exam.paperContext.userInterface;

import exam.paperContext.domain.model.paper.PaperId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String uri;

    public static BlankQuizDTO from(PaperId paperId) {
        return new BlankQuizDTO("papers/" + paperId);
    };
}
