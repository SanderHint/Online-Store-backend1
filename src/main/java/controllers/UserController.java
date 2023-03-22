package controllers;

import exceptions.UserNotFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.AuthorityService;
import services.UserService;

/**
 * @author Sander Hintsov
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public String showAllUserPage(Model model) {
        model.addAttribute("users",userService.findAllUsers());
        return "user/list-user";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model, @ModelAttribute("user") User user, @ModelAttribute("message")String message,
                                 @ModelAttribute("messageType") String messageType) {
        model.addAttribute("authorities",authorityService.findAllAuthorities());
        return "user/create-user";
    }

    @PostMapping("/signup")
    public String createUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.findUserByEmail(user.getEmail());
            redirectAttributes.addFlashAttribute("message",String.format("User(%s) already exist", user.getEmail()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/user/signup";
        } catch (UserNotFoundException e) {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "Signup successful!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/";
        }

    }
}