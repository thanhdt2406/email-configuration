package controller;

import dao.IEmailConfigDAO;
import model.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailConfigController {
    @Autowired
    private IEmailConfigDAO emailConfigDAO;

    @GetMapping("/index")
    public ModelAndView showConfig(){
        return new ModelAndView("index","configs",emailConfigDAO.getAll());
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        return new ModelAndView("create","emailConfig",new EmailConfig());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute EmailConfig emailConfig){
        emailConfig.setId((int) Math.round(Math.random()*100000));
        emailConfigDAO.create(emailConfig);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        return new ModelAndView("edit","emailConfig",emailConfigDAO.getById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute EmailConfig emailConfig){
        emailConfigDAO.update(emailConfig);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        emailConfigDAO.delete(id);
        return new ModelAndView("redirect:/index");
    }

}
