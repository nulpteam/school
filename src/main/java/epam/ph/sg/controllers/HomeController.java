package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({"/index.html", "/index", "/"})
	public ModelAndView  index(){
        return new ModelAndView("index");
    }
}