package com.HP.Dojo_Overflow.controllers;

import com.HP.Dojo_Overflow.models.Answer;
import com.HP.Dojo_Overflow.models.Qtags;
import com.HP.Dojo_Overflow.models.Question;
import com.HP.Dojo_Overflow.services.AnswerService;
import com.HP.Dojo_Overflow.services.QtagsService;
import com.HP.Dojo_Overflow.services.QuestionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RouteController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final QtagsService qtagsService;

    public RouteController(QuestionService questionService, AnswerService answerService, QtagsService qtagsService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.qtagsService = qtagsService;
    }

    //main index
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("questions", questionService.allQuestion());
        return "index";
    }

    @RequestMapping("/question/new")
    public String question(Model model, RedirectAttributes redirectAttributes) {
        return "index.1";
    }

    @PostMapping("/create/question")
    public String createQuestion(Model model, @RequestParam(value="tag") String tag, @RequestParam(value="question") String question, RedirectAttributes err){
        if(tag.isEmpty() && question.isEmpty()){
            err.addFlashAttribute("errors4", "all inputs must be filled input must be full");
            model.addAttribute("errors4", err.getFlashAttributes());
            return "index.1";
        }
        if(tag.isEmpty()) {
            err.addFlashAttribute("errors2", "Tag input must be full");
            model.addAttribute("errors2", err.getFlashAttributes());
            System.out.println("test2");
            return "index.1";
        }
        else if(question.isEmpty()) {
            err.addFlashAttribute("errors1", "Question input must be full");
            model.addAttribute("errors1", err.getFlashAttributes());
            System.out.println("test1");
            return "index.1";
        } else{

            List<Qtags> currenttags = new ArrayList<Qtags>();
            List<String> allTags = Arrays.asList(tag.split(", "));
            if (allTags.size() < 4) {
                for(int i = 0; i < allTags.size(); i++) {
                    //check if tag exists
                    List<Qtags> current = qtagsService.findTag(allTags.get(i));
                    System.out.println(current);
                    if (!current.isEmpty()) {
                        // found add
                        System.out.println("hello");
                        currenttags.add(current.get(0));
                    }else{
                        //not found create
                        System.out.println("hello");
                        Qtags tags = new Qtags(allTags.get(i));
                        Qtags newTag = qtagsService.createTags(tags);
                        currenttags.add(newTag);
                    }
                }
                //create question
                Question newQuestion = new Question(question, currenttags);
                questionService.createQuestion(newQuestion);
                return "redirect:/";
            } else {
                System.out.println("test2");
                err.addFlashAttribute("errors3", "No More then three Tags");
                model.addAttribute("errors3", err.getFlashAttributes());
                return "index.1";
            }
        }

    }

    @RequestMapping("/answer/{id}")
    public String answer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.getQuestion(id));
        model.addAttribute("answers", answerService.allAnswer());
        return "index.2";
    }

    @PostMapping("/answer/new/{id}")
    public String createAnswer(Model model, @PathVariable(value="id") Long id, 
            @RequestParam(value = "answer") String answer) {
        Question question = questionService.getQuestion(id);
        Answer newAnswer = new Answer(answer, question);
        answerService.createAnswer(newAnswer);

        return "redirect:/answer/" + id;
    }




}
