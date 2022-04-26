package mk.ukim.finki.wp.mycinema.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogOutController {

    @GetMapping
    public String getLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";

    }

}
