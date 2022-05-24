package com.leonsh.java.code.designpattern.command;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CommandPattern
 *
 * @author leonsh
 * @date 2020-12-01 09:14
 **/
public class CommandPattern {

    public static void main(String[] args) {
        /**
         * 用于对其他的模块发送命令
         */
        CommandA commandA = new CommandA();
        CommandB commandB = new CommandB();

        Invoker invoker = new Invoker();
        invoker.setCommand(commandA);
        invoker.execute();

        invoker.setCommand(commandB);
        invoker.execute();
    }

    public interface Command {
        void execute();
    }

    public static class CommandA implements Command {
        @Override
        public void execute() {
            System.out.println("这是命令A的实现");
        }
    }

    public static class CommandB implements Command {
        @Override
        public void execute() {
            System.out.println("这是命令B的实现");
        }
    }

    @Data
    @NoArgsConstructor
    public static class Invoker {
        Command command;

        public void execute() {
            System.out.println("一些A的别的逻辑");
            command.execute();
            System.out.println("一些B的别的逻辑");
        }
    }



}
