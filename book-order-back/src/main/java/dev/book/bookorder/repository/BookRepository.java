package dev.book.bookorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.book.bookorder.model.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name); // 우리가 원하는 메서드 만들 수 있음. 이름을 규칙대로 잘 만들어야함.
}
