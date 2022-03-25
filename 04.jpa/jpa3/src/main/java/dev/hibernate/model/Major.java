package dev.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Major {
    
    //id 필드(MAJOR_ID)
    @Id
    @Column(name="MAJOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // majorName 필드(MAJOR_NAME)
    @Column(name="MAJOR_NAME")
    private String majorName;

    // 반대쪽 매핑의 필드 이름을 설정. 
    // Student.java의 Major 'major' 필드를 지정.
    @OneToMany(mappedBy = "major") // 하나의 학과(1)는 여러학생들(N)을 보유하고 있음.
    private List<Student> students = new ArrayList<>();


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Major() {}

    public Major(Long id, String majorName) {
        this.id = id;
        this.majorName = majorName;
    }

    public Major(String majorName) {
        this.majorName = majorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major [id=" + id + ", majorName=" + majorName + "]";
    }
    
}
