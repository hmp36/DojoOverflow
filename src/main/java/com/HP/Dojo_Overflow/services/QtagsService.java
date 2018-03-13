package com.HP.Dojo_Overflow.services;

import org.springframework.stereotype.Service;
import com.HP.Dojo_Overflow.models.Qtags;
import com.HP.Dojo_Overflow.repositories.QtagsRepository;
import java.util.List;

@Service
public class QtagsService {
    private QtagsRepository qtagsRepo;

    public QtagsService(QtagsRepository qtagsRepo) {
        this.qtagsRepo = qtagsRepo;
    }

    public Qtags getTags(Long id) {
        return qtagsRepo.findOne(id);
    }
    
    public Qtags createTags(Qtags tag) {
        return qtagsRepo.save(tag);
    }

    public List<Qtags> findTag(String search) {
        return qtagsRepo.findBySubjectContaining(search);
    }
}
