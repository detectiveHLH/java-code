package com.leonsh.java.code.basic;

import com.leonsh.java.code.util.OSExecutor;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * 用于探索 Enum 中的 values() 方法是从哪里来的
 *
 * @author leonsh
 * @date 2022-07-07 20:01
 **/
public class EnumExplore {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------------------------------------------------");
        System.out.printf("Analyze %s\n", enumClass);
        System.out.println("interface: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.printf("Base: %s\n", enumClass.getSuperclass());
        System.out.print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        exploreMethods.removeAll(enumMethods);
        System.out.printf("exploreMethods.removeAll(enumsMethods): %s\n", exploreMethods);

        // 反编译 enum 类
        OSExecutor.command("javap -cp target/classes/com/leonsh/java/code/basic/ Explore");
    }
}