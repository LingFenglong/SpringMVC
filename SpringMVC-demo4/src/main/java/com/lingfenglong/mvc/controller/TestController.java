package com.lingfenglong.mvc.controller;

import com.lingfenglong.mvc.bean.Person;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)    // 仅能获取请求体
    public String testRequestBody(Person person, @RequestBody String requestBody) {
        System.out.println("person: " + person);
        System.out.println("req: " + requestBody);
        return "success";
    }
    @RequestMapping("/testRequestEntity")
    public String testRequestBody(Person person, RequestEntity<String> requestEntity) {
        System.out.println("person: " + person);
        System.out.println("requestEntity: " + requestEntity.toString());
        System.out.println("host: " + requestEntity.getHeaders().getHost());
        return "success";
    }
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public Person testResponseBody() {
        Person zhangsan = new Person("zhangsan", 18);
        return zhangsan;
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<String> testResponseEntity() {
        Person zhangsan = new Person("zhangsan", 18);

        return null;
    }
}
