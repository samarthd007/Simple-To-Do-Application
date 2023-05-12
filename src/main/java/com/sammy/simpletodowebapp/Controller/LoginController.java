package com.sammy.simpletodowebapp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private final Logger logger= LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String gotodefault(ModelMap modelMap) {
        modelMap.put("name","sammy");
        return "welcome";
    }

}
