package com.HP.Dojo_Overflow.repositories;

import com.HP.Dojo_Overflow.models.Answer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAll();

}