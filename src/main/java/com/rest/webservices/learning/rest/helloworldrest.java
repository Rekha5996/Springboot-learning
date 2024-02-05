package com.rest.webservices.learning.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class helloworldrest {

    //@RequestMapping(method = RequestMethod.GET,path="/helloworld")
    @GetMapping(path="/helloworld")
    public String printHelloWorld(){
        return "helloworld123";
    }
    @GetMapping(path="/helloworld-bean")
    public HelloWorld printHelloWorldBean(){
        return new HelloWorld("Hi Welcome to world");}

    @GetMapping("/helloworld/{name}")
    public  HelloWorld printworldwithpath(@PathVariable String name){
        return new HelloWorld(String.format("Hello path param world,%s",name));
    }
}
