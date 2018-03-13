package com.HP.Dojo_Overflow.services;

import com.HP.Dojo_Overflow.models.Answer;
import com.HP.Dojo_Overflow.repositories.AnswerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswerRepository answerRepo;

    public AnswerService(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    public List<Answer> allAnswer() {
        return answerRepo.findAll();
    }

    public void createAnswer(Answer answer) {
        answerRepo.save(answer);
    }
}