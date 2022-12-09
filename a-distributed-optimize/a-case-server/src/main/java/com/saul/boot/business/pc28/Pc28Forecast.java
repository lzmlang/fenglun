package com.saul.boot.business.pc28;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/5/26 10:15 上午
 */
public class Pc28Forecast {
    public static void main(String[] args) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now().format(dtf2));


        System.out.println(new BigDecimal(102 * 3 - 30).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//        System.out.println(new Date().getTime());
//        getForecastResult();
        Timestamp synTime = new Timestamp(System.currentTimeMillis());
        System.out.println(synTime.toLocalDateTime());
        Timestamp delaySynTime = new Timestamp(System.currentTimeMillis() - 1000 * 60 * 60 * 48L);//有订单延迟2个小时
        System.out.println(delaySynTime);
    }

    public static void getForecastResult(int times) {
        Integer a = 0;//大
        Integer b = 0;//双
        Integer c = 0;//小
        Integer d = 0;//单
        Integer a20 = 0;//大
        Integer b20 = 0;//双
        Integer c20 = 0;//小
        Integer d20 = 0;//单

        Integer first = 0;
        for (int i = 0; i < 29; i++) {
            Integer sumNum = getSumNum();
            if (i == 0) {
                first = sumNum;
            }
            //统计前面20次
            if (i >= 0 && i < 20) {
                if (sumNum % 2 == 0) {
                    b20++;
                } else {
                    d20++;
                }
                if (sumNum >= 14) {
                    a20++;
                } else {
                    c20++;
                }
            }
            if (sumNum % 2 == 0) {
                b++;
            } else {
                d++;
            }
            if (sumNum >= 14) {
                a++;
            } else {
                c++;
            }
        }
        System.out.println(times + "期：");
        System.out.println("第一次：" + first);
        System.out.println(a + "大 " + c + "小 " + b + "双 " + d + "单");
        System.out.println("前20次=" + a20 + "大 " + c20 + "小 " + b20 + "双 " + d20 + "单");
    }

    private static Integer getSumNum() {
        Integer[] one = {2, 5, 8, 11, 14, 17};
        Integer[] two = {3, 6, 9, 12, 15, 18};
        Integer[] three = {4, 7, 10, 13, 16, 19};
        List<Integer> listone = Arrays.asList(one);
        List<Integer> listtwo = Arrays.asList(two);
        List<Integer> listthree = Arrays.asList(three);

        //不可重复且有序的20个数字
        Set<Integer> dataset = getIntegers();
        Integer bai = 0, shi = 0, ge = 0;
        ArrayList<Integer> intList = new ArrayList<>();
        Iterator<Integer> iterator = dataset.iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next());
        }
        for (int i = 0; i < intList.size(); i++) {
            if (listone.contains(i)) {
                bai += intList.get(i);
            }
            if (listtwo.contains(i)) {
                shi += intList.get(i);
            }
            if (listthree.contains(i)) {
                ge += intList.get(i);
            }
        }
        String firstNum = bai % 10 + "";
        String towNum = shi % 10 + "";
        String threeNum = ge % 10 + "";
        Integer sumnum = 0;
        try {
            sumnum = Integer.valueOf(firstNum) + Integer.valueOf(towNum) + Integer.valueOf(threeNum);
        } catch (Exception e) {
            System.out.println("出错了！！！三个数字：" + firstNum + "+" + towNum + "+" + threeNum + "+" + ge);
        }
//        System.out.println("最终三个数字：" + firstNum + "+" + towNum + "+" + threeNum + "=" + sumnum);
        return sumnum;
    }

    private static Set<Integer> getIntegers() {
        Set<Integer> dataset = new LinkedHashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(100);
            dataset.add(num);
        }
        if (dataset.size() < 20) {
            for (int i = 0; i < 100000; i++) {
                int num = random.nextInt(100);
                if (dataset.size() == 20) {
                    break;
                }
                dataset.add(num);
            }
        }
        return dataset;
    }

}
