package com.HP.Dojo_Overflow.repositories;

import com.HP.Dojo_Overflow.models.QuestionTags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTagsRepository extends CrudRepository<QuestionTags, Long> {

}
