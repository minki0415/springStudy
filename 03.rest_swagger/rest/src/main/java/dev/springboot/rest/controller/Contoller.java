package dev.springboot.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.springboot.rest.model.BookDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController // @Contoller(@Component, Bean 객체로 등록) + @ResponseBody(JSON 데이터 반환용)
@RequestMapping("/api/v1") // localhost:8090/api/v1 으로 기본 url 설정 
public class Contoller {

    // GET Methods
    
    // 별도의 매개변수(parameter)가 없는 GET 요청
    // http://localhost:8090/api/v1/book
    @ApiOperation(value = "GET 요청 기본 방식")
    @GetMapping("/book")
    public String getBook() {
        return "The Old Man and Sea";
    }

    // @RequsetParam()
    // http://localhost:8090/v1?name=value&author=value...
    @GetMapping("/book/req")
    public String getBookWithParam(
        @ApiParam(value="이름", required = true) @RequestParam String name, 
        @ApiParam(value="저자", required = false) @RequestParam String author) {
        return String.format("%s의 저자 %s", name, author);
    }

    // @pathVariable을 활용한 GET 요청
    // http://localhost:8090.api/v1/:bookName
    @GetMapping("/book/{bookName}")
    public String getBookWithName(@PathVariable String bookName) {
        return bookName;
    }

    // DTO(Data Transfer Object) 객체 반환하는 GET 요청
    // http://localhost:8090/api/v1/book/dto?name=책이름&author=저자
    @GetMapping("/book/dto")
    public BookDto getBookDto(BookDto bookDto) {
        return bookDto;
    }

    
    //POST Methods
    // http://localhost:8090/api/v1/book
    @PostMapping("/book")
    public String insertBook(@RequestBody BookDto bookDto) {
        BookDto book = bookDto;

        return book.toString();
    }

    // http://localhost:8090/api/v1/book2, BookDto 객체를 JSON 형식으로 반환
    @PostMapping("/book2")
    public BookDto insertBook2(@RequestBody BookDto bookDto) {
        BookDto book = bookDto;
        return book;
    }

    //PUT Methods
    @PutMapping("/book")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        BookDto book = bookDto;
        return book;
    }

    // Delete Methods
    @DeleteMapping("/book/{bookName}")
    public String deleteBook(@PathVariable String bookName) {
        // delete SQL 실행
        
        return "book : " + bookName + "가 제거되었습니다.";
    }

}
