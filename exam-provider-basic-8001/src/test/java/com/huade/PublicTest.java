package com.huade;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class PublicTest {

    class Student {
        private String Id;
        private String age;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "Id='" + Id + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public Student(String id, String age) {
            Id = id;
            this.age = age;
        }

    }

    @Test
    void name() {
        Student student1 = new Student("123","123");
        Student student2 = new Student("1231","1231");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
