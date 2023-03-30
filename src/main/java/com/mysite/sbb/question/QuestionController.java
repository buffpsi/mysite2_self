package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question/qlist";
    }
}
