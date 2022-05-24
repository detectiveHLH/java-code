package com.leonsh.java.code.niodemo.bytebuffer;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 遍历一个文件中的所有文件
 */
public class TestFilesWalkTree {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("/Users/luohongwei/projects"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("===>" + dir);
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                System.out.println(file);
                return super.visitFile(file, attrs);
            }
        });
    }
}
