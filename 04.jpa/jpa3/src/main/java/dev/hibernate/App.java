package dev.hibernate;

import dev.hibernate.model.Major;
import dev.hibernate.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        Student student1 = new Student(1L, "Kim");
        Student student2 = new Student(2L, "Park");

        Major major = new Major(1L, "컴퓨터공학과");

        student1.setMajor(major);
        student2.setMajor(major);

        // student1이 속한 학과 조회
        // student1.getMajor() -> join을 통한 수행
        // major.getMajorName() -> join 수행 x , select * from major; 와 동일
        Major foundMajor = student1.getMajor(); // 컴퓨터 공학,
        System.out.println(foundMajor.getMajorName());
        System.out.println(foundMajor); // Major 클래스에서 toString 오버라이딩
    }
}
