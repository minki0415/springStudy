package dev.hibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.hibernate.model.Book;

public class AppWithMySQL 
{
    public static void main( String[] args ) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        // EntityMangerFactory를 통해 EntityManager 객체 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Book book = new Book();
            // book.setId("book1");
            book.setBookName("The little prince");
            book.setPubDate(new Date());

            // book data DB Insert
            // 등록, em.persist(entity);
            em.persist(book); // INSERT INTO BOOK (ID, BOOKNAME, PUB_DATE) VALUES('book1', "The little prince", "현재 날짜 값")
        
            // 수정, em.update() 같은 별도의 수정 메서드가 존재하지 않음.
            // 어떤 엔터티가 변경되었는지만 JPA가 추적함.
            book.setBookName("어른왕자"); //UPDATE MEMBER SET BOOK_NAME = "어른왕자" WHERE ID = "book1";
            
            // 한 행 조회 : em.find(조회할 엔터티의 타입, @Id로 매핑한 필드 값)
            Book findBook = em.find(Book.class, 1L);
            System.out.println(findBook.getBookName()); // 어른왕자 출력

            // 엔터티 삭제 : em.remove(삭제할 entity);
            em.remove(findBook);

            tx.commit();

        } catch(Exception e) { // 매개변수의 다형성, 에러가 발생하면 e라는 변수에 저장 
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
