package com.saul.datastructure.array;

/**
 * 自定义list测试类
 *
 * @author 罗泽民
 * @description
 * @date 2020/11/18 21:55
 */
public class Test {

    public static void main(String[] args) {
        MyArray arr = new MyArray();
//        MyArray[] myArrays = new MyArray[]{};
        arr.insertSort(2);
        arr.insertSort(45);
        arr.insertSort(6);
        arr.insertSort(9);
        arr.display();

        System.out.println(arr.binarySearch(45));
    }
}
