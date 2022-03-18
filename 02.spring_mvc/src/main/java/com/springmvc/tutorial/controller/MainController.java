package com.springmvc.tutorial.controller;

import com.springmvc.tutorial.model.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @Controller
@RestController //ModelAndView를 활용하지 않는 형태
public class MainController {
    
    // localhost:8090
    @RequestMapping("/")
    public String init() {
        return "index"; // index.jsp
    }

    // 2. ModelAndView.class, Servlet/JSP 활용 방식
    // @RequestMapping("/add")
    // public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");
    //     modelAndView.addObject("book", request.getParameter("name"));
    //     modelAndView.addObject("author", request.getParameter("author"));

    //     return modelAndView;
    // }

    // 3. RequestParam 방식, (HttpServletRequest보다 간소화된 상태)
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("name") String name, @RequestParam String author) {

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");
    //     modelAndView.addObject("book", name);
    //     modelAndView.addObject("author", author);

    //     return modelAndView;
    // }

    // 4. JSON 객체 반환 방식, @ResponseBody
    // @RestController = @Controller + @ResponseBody (java 객체를 json으로 바꿔서 HTTP body에 담는 역할)
    @RequestMapping(value="/get")
    public Book getBook(@RequestParam("name") String name, @RequestParam("author") String author) {
        
        // Service(비즈니스 로직) -> DAO(직접 DB 접근)
        // DB에서 받은 Book 데이터
        // 비즈니스 로직 및 DB 처리 후, JAVA(JSON) 객체 반환

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);

        return book;
    }
    

}