package com.saul.boot.business.entity.po;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/1/23 4:09 下午
 */
public class Test {
    public static void main(String[] args) {
        Long aa = 333333L;
        Long bb = 333333L;
        Long cc = 111111L;
        long dd = 333333L;
        System.out.println(dd >= aa.longValue());
        System.out.println(aa >= cc.longValue());

        List<CoreUser> list = new ArrayList<>();
        CoreUser coreUser = new CoreUser();
        coreUser.setId(2L);
        coreUser.setStockNum(2);
        CoreUser coreUser2 = new CoreUser();
        coreUser2.setId(3L);
        coreUser2.setStockNum(2);
        CoreUser coreUser3 = new CoreUser();
        coreUser3.setId(4L);
        coreUser3.setStockNum(2);
        CoreUser coreUser4 = new CoreUser();
        coreUser4.setId(5L);
        coreUser4.setStockNum(4);

        list.add(coreUser);
        list.add(coreUser2);
        list.add(coreUser3);
        list.add(coreUser4);
        System.out.println(list.stream().anyMatch(bean -> bean.getId().equals(387225144556037L)));
        //按照StockNum排序
        List<CoreUser> sortList = list.stream().filter(bean -> bean.getStockNum() > 0).sorted(Comparator.comparing(CoreUser::getStockNum).reversed()).collect(Collectors.toList());
        int totalGiveNum = 5;
        while (totalGiveNum > 0) {
            for (CoreUser user : sortList) {
                if (totalGiveNum == 0) {
                    break;
                }
                user.setOneNum((null == user.getOneNum() ? 0 : user.getOneNum()) + 1);
                user.setStockNum(user.getStockNum() - 1);
                totalGiveNum -= 1;
            }

        }
        //按照oneNum进行过滤排序
        List<CoreUser> result = sortList.stream().filter(bean -> bean.getOneNum() > 0).sorted(Comparator.comparing(CoreUser::getOneNum).reversed()).collect(Collectors.toList());

        for (CoreUser user : result) {
            System.out.println(user.getId() + "--->库存数" + user.getStockNum() + "-->赠品数" + user.getOneNum());
        }
    }

    private static int getTotalGiveNum(List<CoreUser> result, int totalGiveNum, List<CoreUser> collect) {
        CoreUser giveItem0 = collect.get(0);
        int stock0 = giveItem0.getStockNum();
        //如果结果集中有了.id就+1,没有就set一个1
        if (result.contains(giveItem0)) {
            giveItem0.setOneNum(giveItem0.getOneNum() + 1);
        } else {
            giveItem0.setOneNum(1);
            result.add(giveItem0);
        }
        totalGiveNum -= 1;
        //保证下一次排序的时候不会排在第一位
        giveItem0.setStockNum(stock0 - 1);
        return totalGiveNum;
    }

    private static class Method001 {
        private boolean myResult;
        private List<CoreUser> list;
        private List<CoreUser> result;
        private int totalGiveNum;

        public Method001(List<CoreUser> list, List<CoreUser> result, int totalGiveNum) {
            this.list = list;
            this.result = result;
            this.totalGiveNum = totalGiveNum;
        }

        boolean is() {
            return myResult;
        }

        public int getTotalGiveNum() {
            return totalGiveNum;
        }

        public Method001 invoke() {
            List<CoreUser> sortList = list.stream().filter(bean -> bean.getStockNum() > 0).sorted(Comparator.comparing(CoreUser::getStockNum).reversed()).collect(Collectors.toList());
            //如果没偶库存了.就直接结束循环
            if (CollectionUtil.isEmpty(sortList)) {
                myResult = true;
                return this;
            }
            for (int i = 0; i < sortList.size(); i++) {
                if (totalGiveNum == 0) {
                    break;
                }
                CoreUser giveItem0 = sortList.get(i);
                Integer stockNum = giveItem0.getStockNum();
                if (result.contains(giveItem0)) {
                    giveItem0.setOneNum(giveItem0.getOneNum() + 1);
                } else {
                    giveItem0.setOneNum(1);
                    result.add(giveItem0);
                }
                //保证下一次排序的时候不会排在第一位
                giveItem0.setStockNum(stockNum - 1);
                totalGiveNum -= 1;

            }
            myResult = false;
            return this;
        }
    }
}
