package com.saul.design_model.aaaadapter;

import com.saul.design_model.aaaadapter.interfaceadpter.SourceSub1;
import com.saul.design_model.aaaadapter.interfaceadpter.SourceSub2;

/**
 * @author 罗泽民
 * @description 适配器模式test
 * @date 2020/11/1 14:36
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();

        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();
        sourceSub1.method1();
        sourceSub1.method2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}
