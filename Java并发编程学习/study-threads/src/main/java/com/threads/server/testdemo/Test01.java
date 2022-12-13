package com.threads.server.testdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈〉<br>
 *
 * @author luo_zm
 * @company 潭州教育网络科技有限公司
 * @create 2019/7/31
 * @since 1.0.0
 */
public class Test01 {

  public static void main(String[] args) {
    String ss = "0 0 12 * * ?";
    String ymd = "0 0 12 8 8 ?";
    String[] arrExc = ss.replace("?", "").trim().split(" ");
    String[] arrss = ymd.replace("?", "").trim().split(" ");
    String s = arrToString(arrExc);
    String s1 = arrToString(arrss);

    System.out.println(s);
    System.out.println(s1);
    System.out.println(method(66));

  }

  public static int method(int aa) {
    if (aa == 55) {
      aa += 6;
    }
    return aa;
  }

  public static String arrToString(String[] arr) {
    String excuteTime = "";
    if (arr.length == 5) {
      for (int i = arr.length - 1; i >= 0; i--) {
        excuteTime += formatNumber(arr[i]);
        if (i == 4 && !"*".equals(arr[i])) {
          excuteTime += "-";
        }
        if (i == 3) {
          excuteTime += " ";
        }
        if (i < 3 && i > 0) {
          excuteTime += ":";
        }
      }
    }
    return excuteTime;
  }

  public static String formatNumber(String sNumber) {
    if ("*".equals(sNumber)) {
      return "";
    }
    if (isNumber(sNumber)) {
      int number = Integer.valueOf(sNumber);
      if (number < 10) {
        return "0" + sNumber;
      }
    }
    return sNumber;
  }

  public static boolean isNumber(String value) { // 检查是否是数字
    String patternStr = "^\\d+$";
    Pattern p = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE); // 忽略大小写;
    Matcher m = p.matcher(value);
    return m.find();
  }
}
