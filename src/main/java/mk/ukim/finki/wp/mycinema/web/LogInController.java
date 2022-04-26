package mk.ukim.finki.wp.mycinema.web;

import mk.ukim.finki.wp.mycinema.model.User;
import mk.ukim.finki.wp.mycinema.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wp.mycinema.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LogInController {

    public final AuthService authService;

    public LogInController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping
    public String getLoginPage(){
        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        User user=null;
        try{
            user =this.authService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        }catch (InvalidUserCredentialsException e){
            model.addAttribute("hasError", true);
            model.addAttribute("error",e.getMessage());
            return "login.html";
        }

    }
}

