package cn.noahcode.community.controller;

import cn.noahcode.community.dto.CommentDTO;
import cn.noahcode.community.dto.QuestionDTO;
import cn.noahcode.community.enums.CommentTypeEnum;
import cn.noahcode.community.service.CommentService;
import cn.noahcode.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author NoahCode
 * @date 2020/1/27
 * @description
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> comments = commentService.listByQuestionId(id, CommentTypeEnum.QUESTION);
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }
}
