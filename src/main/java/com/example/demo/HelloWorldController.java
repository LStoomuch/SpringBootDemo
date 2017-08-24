package com.example.demo;

import com.example.Service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liaosheng on 2017/8/23.
 */
@Controller
public class HelloWorldController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String sayHi(){
        return "helloGet";
    }
    @RequestMapping(value = "/helloHtml",method = RequestMethod.GET)
    public String sayHiPost(){
        return "<html><body><table><tr><h1>apple</h1></tr><tr><h2>abc</h2></tr></table></body></html>";
    }
    @RequestMapping("/hello2")
    public List<String> hello2() {
        return Arrays.asList(new String[] { "A", "B", "C" });
    }
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name,Model model){
        String index = demoService.demoService();
        model.addAttribute("name",name);
        model.addAttribute("index",index);
        return "hello";
    }
//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }
}
