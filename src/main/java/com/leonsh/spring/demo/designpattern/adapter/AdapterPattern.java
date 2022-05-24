package com.leonsh.spring.demo.designpattern.adapter;

/**
 * AdapterPattern
 *
 * @author leonsh
 * @date 2020-11-29 21:36
 **/
public class AdapterPattern {

    public static void main(String[] args) {
        NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();

        oldInterface.newExecute();
        newInterface.newExecute();
    }

    public static class NewInterfaceAdapter implements NewInterface {

        private OldInterface oldInterface;

        public NewInterfaceAdapter(OldInterface oldInterface) {
            this.oldInterface = oldInterface;
        }

        @Override
        public void newExecute() {
            oldInterface.oldExecute();
        }

    }

    public interface OldInterface {
        /**
         * 老版本接口
         */
        void oldExecute();
    }

    public static class OldInterfaceImpl implements OldInterface {

        @Override
        public void oldExecute() {
            System.out.println("老版本接口的实现");
        }
    }

    public interface NewInterface {
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
