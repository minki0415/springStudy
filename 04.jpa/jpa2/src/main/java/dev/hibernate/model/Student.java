package dev.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id // STUDENT TABLE의 기본키(PK)로 지정
    @Column(name="STUDENT_ID") // TABLE의 COLUMN명을 STUDENT_ID로 변경
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL AUTO_INCREMENT 설정 
    private Long id;

    @Column(name="STUDENT_NAME")
    private String studentName;

    @ManyToOne // Student와 Major는 N:1 관계(다대일 관계)
    @JoinColumn(name="MAJOR_ID")
    private Major major;


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {}

    public Student(Long id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    
}
