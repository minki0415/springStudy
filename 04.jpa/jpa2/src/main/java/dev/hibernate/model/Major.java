package dev.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
