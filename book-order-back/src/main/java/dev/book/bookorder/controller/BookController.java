package dev.book.bookorder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.book.bookorder.model.dto.BookDTO;
import dev.book.bookorder.service.BookService;

@CrossOrigin(origins = "*")
@RestController // @Controller + @ResponseBody
// @Controller : @Component가 각 클래스의 이름에 맞게 직관적인 명칭으로 변경된 것
// @ResponseBody : JSON
@RequestMapping("/api/v1/books") //localhost:8090/api/v1/books ~
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping() // GET : api/v1/books
    public List<BookDTO> findAllBooks(){
        // service -> repository -> DB
        // 전체 책 데이터 조회
        return bookService.findAllBooks();
    }
}
