package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryPaperReadRepository {
    private PaperRepository paperRepository;

    @Autowired
    public MemoryPaperReadRepository(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }


    public List<Paper> getAllByReversedOrder() {
        return paperRepository.getAll();
    }
}
