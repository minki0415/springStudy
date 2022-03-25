package dev.book.bookorder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.book.bookorder.model.dto.BookDTO;
import dev.book.bookorder.model.entity.Book;
import dev.book.bookorder.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBooks() {
        List<Book> list = bookRepository.findAll(); // Spring Data JPA 활용 부분(em.find())
        List<BookDTO> result = list.stream().map(r -> new BookDTO(r)).collect(Collectors.toList());
        return result;
    }
    
}
