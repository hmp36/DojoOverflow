package com.HP.Dojo_Overflow.services;

import com.HP.Dojo_Overflow.models.Question;
import com.HP.Dojo_Overflow.repositories.QuestionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepository questionRepo;

    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }
    
    public List<Question> allQuestion() {
        return questionRepo.findAll();
        }

    public void createQuestion(Question question) {
        questionRepo.save(question);
    }

    public Question getQuestion(Long id) {
        return questionRepo.findOne(id);
    }
}