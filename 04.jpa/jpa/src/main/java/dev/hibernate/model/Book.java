package dev.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity annotation
 * - 해당 class를 JPA가 관리하는 Entity로 인식하게 됨.
 * - 별도의 Table annotation을 지정하지 않으면 해당 클래스(BOOK)의 이름으로 테이블이 생성됨
 *      -> 'BOOK' Table
 * 
 * Entity Annotation 적용 시 주의할 점
 *  1. 기본 생성자(Default constructor) 필수(JPA가 엔터티 객체를 생성할 때 기본 생성자를 활용하기 때문)
 *  2. 값을 저장할 필드에 final을 사용하면 안됨. 
 */

@Entity 
// @Table(name="BooS") // table명이 BOOKS로 생성됨.
public class Book {
    /**
     * JPA의 기본 키 생성 전략
     * 1. 직접 할당 : 기본키를 애플리케이션에서 직접 할당
     * 2. 자동 생성 : 대리키 활용 (strategy = GenerationType.IDENTITY or SEQUENCE or TABLE)
     *      1) IDENTITY : 기본키 생성을 DB한테 위임. (MySQL의 auto_increment)
     *      2) SEQUENCE : DB 시퀀스 기능을 활용 (Oracle에서 지원, MySQL은 미지원)
     *      3) TABLE : 키 생성 테이블을 사용(키를생성해주는 별도의 테이블을 만들고, 시퀀스처럼 사용)
     *          -> 모든 DB에서 사용 가능 
     * 
     * 직접 할당 방식을 사용하기 위해서는 @Id만 쓰면 끝.
     *  예) 
     *      Book book = new Book();
     *      book.setId("book1")
     * 
     * 자동 생성 방식을 사용하기 위해서는 @Id + @GeneratedValue를 추가하고, 원하는 키 생성 전략 선택.
     */
    
    @Id  // primary key(기본키) 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    /**
     * Column annotation : 필드와 컬럼 매핑하는 
     */
    @Column(name="book_name", nullable = false)
    // book table의 컬럼명은 book_name, not null 설정 
    private String bookName; //camelCase(Java) / snake_case(DB)

    // @Column(name="book_author") // 일관성있는 컬럼명 설정 위해 추가할 수도 있음
    private String author;

    @Temporal(TemporalType.TIMESTAMP) // java.util.date, util.Calendar 매핑할 때 사용
    //TemporalType.DATE : 날짜, DB date 타입과 매핑(ex. 2022-03-21)
    //TemporalType.TIME : 시간, DB time 타입과 매핑(ex. 09:30:23) 
    //TemporalType.TIMESTAMP : 날짜와 시간, DB timestamp 타입과 매핑(ex. 2022-12-23 09:53:24)
    
    @Column(name="pub_date")
    private Date pubDate;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    

    
}
