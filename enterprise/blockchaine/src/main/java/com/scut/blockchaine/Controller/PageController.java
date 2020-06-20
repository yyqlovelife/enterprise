package com.scut.blockchaine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/enterprise")
    public String enterprise(){
        return "enterprise";
    }
    @RequestMapping(value = "/enterprise/enterprise_applyscore")
    public String enterprise_applyscore(){
        return "enterprise/enterprise_applyscore";
    }
    @RequestMapping(value = "/enterprise/enterprise_convert")
    public String enterprise_convert(){
        return "enterprise/enterprise_convert";
    }
    @RequestMapping(value = "/enterprise/enterprise_queryscore")
    public String enterprise_queryscore(){
        return "enterprise/enterprise_queryscore";
    }
}
