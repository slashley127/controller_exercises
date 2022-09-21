package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello/hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select id='language' name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<input type='submit' value='Greet Me!'>" +
                "<form>" +
                "<body>" +
                "<html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l){
        String greeting = "";

        if(l.equals("english")){
            greeting = "Hello";
        }
        if(l.equals("french")){
            greeting = "Bonjour";
        }
        if(l.equals("italian")){
            greeting = "Bonjourno";
        }
        if(l.equals("spanish")){
            greeting = "Hola";
        }
        if(l.equals("german")){
            greeting = "Hallo";
        }
        return greeting + ", " + n + "!";
    }



}
