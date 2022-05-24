package com.leonsh.java.code.designpattern.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * WithIteratorPattern
 *
 * @author leonsh
 * @date 2020-11-29 20:36
 **/
public class WithIteratorPattern {
    public static void main(String[] args) {

        /**
         * 重点就在于，要把自己提供出去的某个数据结构的新增元素，删除元素，底层的实现逻辑给收敛起来
         * 不对外暴露，让调用方只关心调用接口。然后也可以自己实现自己的迭代器。
         */

        Student student1 = new Student("小明");
        Student student2 = new Student("小王");

        Classroom classroom = new Classroom();
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Iterator<Student> iterator = classroom.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
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
        private List<Student> students;

        public Classroom() {
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            this.students.add(student);
        }

        public Student getStudent(int index) {
            return students.get(index);
        }

        public int getLength() {
            return this.students.size();
        }

        public Iterator<Student> iterator() {
            /**
             * 此处可以自己定义一个自己的迭代器，也可以使用students中List的迭代器
             */
            return new ClassroomIterator(this);
//            return students.iterator();
        }
    }

    /**
     * 代表了一个集合类
     * @author zhonghuashishan
     *
     */
    public interface Aggregate {

        /**
         * 返回迭代器
         * @return iterator
         */
        Iterator<Student> iterator();

    }

    public static class ClassroomIterator implements Iterator<Student> {

        private final Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < classroom.getLength();
        }

        @Override
        public Student next() {
            return classroom.getStudent(index++);
        }
    }
}
