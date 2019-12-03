package cn.noahcode.community.controller;

import cn.noahcode.community.mapper.QuestionMapper;
import cn.noahcode.community.mapper.UserMapper;
import cn.noahcode.community.model.Question;
import cn.noahcode.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author NoahCode
 * @date 2019/12/2
 * @description
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModifield(question.getGmtCreate());
        question.setCreator(user.getId());
        questionMapper.create(question);
        return "redirect:/";
    }
}
