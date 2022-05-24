package com.leonsh.spring.demo.designpattern.adapter;

/**
 * WithoutAdapterPattern
 *
 * @author leonsh
 * @date 2020-11-29 21:30
 **/
public class WithoutAdapterPattern {

    public static void main(String[] args) {
        OldInterface oldInterface = new OldInterfaceImpl();
        NewInterface newInterface = new NewInterfaceImpl();
        oldInterface.oldExecute();
        newInterface.newExecute();
    }

    public static interface OldInterface {
        /**
         * 老版本接口
         */
        void oldExecute();
    }

    public static class OldInterfaceImpl implements OldInterface{

        @Override
        public void oldExecute() {
            System.out.println("老版本接口的实现");
        }
    }

    public static interface NewInterface {
        /**
         * 新版本实现接口
         */
        void newExecute();
    }

    public static class NewInterfaceImpl implements NewInterface {

        @Override
        public void newExecute() {
            System.out.println("新版本的接口实现");
        }
    }

}
