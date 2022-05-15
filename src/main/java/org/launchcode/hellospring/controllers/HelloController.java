package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("goodbye") //http://localhost:8080/hello/goodbye Displays: Hello goodbye!
    public String goodbye(){return "Good bye, Spring";}

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){ //add new request param language
       String properGreeting = HelloController.createMessage(name,language); //since createMessage is static, need to call directly from HelloController
       return  "<h3 style = 'color:purple;'>" + properGreeting + "</h3>";
       //the value name(the text in the input box) will post to http://localhost:8080/hello since value = "hello" and
        //for  action = 'hello'
    }

    @GetMapping("hello/{name}") //http://localhost:8080/hello/Matt entering this URL will Display: Hello Matt!
    public String hellWithQueryParam2(@PathVariable String name){return "Hello " + name + "!";}

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>"+ //submit a request to /hello
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                    "<option value = 'English'> English</option>" +
                    "<option value = 'Spanish'> Spanish</option>" +
                    "<option value = 'French'> French</option>" +
                    "<option value = 'Italian'> Italian</option>" +
                    "<option value = 'German'> German</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>" +
                "</html>"
                ;
    }

    public static String createMessage(String name, String language){
        switch (language){
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour, " + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
                return "Hallo, " + name;
            case "English":
            default:
                return  "Hello, " + name;
        }
    }
}
