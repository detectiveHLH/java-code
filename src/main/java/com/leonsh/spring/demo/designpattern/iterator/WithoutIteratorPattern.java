package com.leonsh.spring.demo.designpattern.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * WithoutIteratorPattern
 *
 * @author leonsh
 * @date 2020-11-29 17:22
 **/
public class WithoutIteratorPattern {

    public static void main(String[] args) {
        /**
         * 假设我们使用第三方提供的  ClassRoom 类
         * 然后我们需要遍历其中的所有学生
         */
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");
        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        Classroom classroom = new Classroom();
        classroom.setStudents(students);

        /**
         * 对所有的学生进行遍历，这次我们使用的for循环，假设后面其实现换成了map呢？现在的思路就有了问题
         */
        Student[] resultStudents = classroom.getStudents();
        for (Student student : resultStudents) {
            System.out.println(student);
        }

    }

    /**
     * 学生类
     */
    @Data
    @AllArgsConstructor
    public static class Student {
        private String name;
    }

    /**
     * 教室类
     */
    @Data
    private static class Classroom {
        private Student[] students;
    }

}
