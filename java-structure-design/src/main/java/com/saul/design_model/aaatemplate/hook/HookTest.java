package com.saul.design_model.aaatemplate.hook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/5/26 10:15 上午
 */
public class HookTest {
    public static void main(String[] args) {
            //钩子函数测试
//        AbstractClass abstractClass = new ChildrenWithHookImp();
//        abstractClass.templateMethod();
//        System.out.println("--------------");
//        AbstractClass abstractClass1 = new ChildrenNoHookImp();
//        abstractClass1.templateMethod();
//
//        System.out.println(505 % 500);
//        System.out.println(500/3);
//        System.out.println(false || false);
        String[][] a = new String[2][];
        String[] s = {"1", "2", "3"};
        String[] s2 = {"4", "5", "6", "7"};
//        a[0]=s;
//        a[1]=s2;
//        for (String[] strings : a) {
//            for (String string : strings) {
//                System.out.println(string);
//
//            }
//        }
        List<String[]> ss = new LinkedList<>();
        ss.add(s);
        ss.add(s2);
        String[][] strings = ss.toArray(a);

        for (String[] strings1 : strings) {
            for (String string : strings1) {
                System.out.println(string);

            }
        }
        System.out.println("______________________aaaa");
        for (String[] strings1 : a) {
            for (String string : strings1) {
                System.out.println(string);

            }
        }


//        TestList testList=new TestList();
//        List<String> strings = testList.getStrings();
//        strings.add("666");
//        for (String string : testList.getStrings()) {
//            System.out.println(string);
//        }

    }

    static class TestList {
        private List<String> strings = new ArrayList<>();

        public List<String> getStrings() {
            return strings;
        }

        public void setStrings(List<String> strings) {
            this.strings = strings;
        }
    }
}
