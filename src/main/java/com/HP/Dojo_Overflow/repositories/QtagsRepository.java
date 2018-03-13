package com.HP.Dojo_Overflow.repositories;

import com.HP.Dojo_Overflow.models.Qtags;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QtagsRepository extends CrudRepository<Qtags, Long> {
    List<Qtags> findAll();
    //findByTagContaining
    List<Qtags> findBySubjectContaining(String search);
}
