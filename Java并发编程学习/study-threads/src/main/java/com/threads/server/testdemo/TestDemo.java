package com.threads.server.testdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/5/21 2:45 下午
 */
public class TestDemo {
    /**
     * 北美洲地区国家: us,ca,mx
     * 欧洲地区国家: uk,de,fr,it,es
     * 其他地区国家: jp,au,sg,ae
     * <p>
     * market对象中有两个属性 公司和国家
     * 请提供一个过滤方法对各个公司下的国家进行过滤,各个公司之间互不影响
     * 如果一个公司下包含北美洲地区国家只要返回其中一个国家,北美洲地区其他的国家需要被方法过滤掉,返回优先级是us>ca<mx
     * 如果一个公司下包含欧洲地去国家也只要返回其中一个国家,欧洲地区其他的国家需要被此方法过滤掉,返回的优先级是uk>de>fr>it>es
     * 其他地区的国家不过滤
     * 例如
     * List<Market> markets=new ArrayList<>();
     * markets.add(new Market("云简","us"));
     * markets.add(new Market("云简","ca"));
     * markets.add(new Market("云简","mx"));
     * markets.add(new Market("云简","de"));
     * markets.add(new Market("云简","it"));
     * markets.add(new Market("云简","sg"));
     * markets.add(new Market("云简","jp"));
     * markets.add(new Market("积加","mx"));
     * markets.add(new Market("积加","ca"));
     * markets.add(new Market("积加","jp"));
     * markets.add(new Market("积加","au"));
     * //过滤后只剩以下对象
     * Market("云简","us");
     * Market("云简","de");
     * Market("云简","sg");
     * Market("云简","jp");
     * Market("积加","ca");
     * Market("积加","jp");
     * Market("积加","au");
     */
    public static void main(String[] args) {
        List<Market> markets = new ArrayList<>();
        markets.add(new Market("云简", "us"));
        markets.add(new Market("云简", "ca"));
        markets.add(new Market("云简", "mx"));
        markets.add(new Market("云简", "de"));
        markets.add(new Market("云简", "it"));
        markets.add(new Market("云简", "sg"));
        markets.add(new Market("云简", "jp"));
        markets.add(new Market("积加", "mx"));
        markets.add(new Market("积加", "ca"));
        markets.add(new Market("积加", "jp"));
        markets.add(new Market("积加", "au"));

    }
}
