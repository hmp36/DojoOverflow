package com.HP.Dojo_Overflow.repositories;

import com.HP.Dojo_Overflow.models.Question;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();

}