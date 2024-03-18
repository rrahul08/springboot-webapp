package com.rahul.springwebapp.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String Sayhello(){
        return "Hello Soldiers!";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String SayhelloHtml(){

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Web app</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Hello Soldiers ! - Html");
        sb.append("</body>");
        sb.append("</html>");


        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String SayhelloJsp(){

        return "sayhello";
    }


}
