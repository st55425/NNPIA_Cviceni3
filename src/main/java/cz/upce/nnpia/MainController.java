package cz.upce.nnpia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private EmailService emailService;


    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public String greetingForm2(@PathVariable("text") String s, Model model) {
        counterService.addVisit();
        model.addAttribute("visits" , counterService.getVisitCount());
        model.addAttribute("subscribers" , counterService.getSubscribersCount());
        Email mail = new Email(s);
        model.addAttribute("email" , mail);
        return "index";
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET} )
    public String greetingSubmit(@ModelAttribute Email mail, Model model) {
        counterService.addVisit();
        emailService.setEmail(mail.getEmail());
        model.addAttribute("info", emailService.getInfo());
        model.addAttribute("visits" , counterService.getVisitCount());
        model.addAttribute("subscribers" , counterService.getSubscribersCount());
        model.addAttribute("email" , new Email());
        return "index";
    }
}
