package com.threads.server.executor;//package com.daydayup.server.executor;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.Cursor;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//import com.nari.pojo.Rdatamp;
//import com.nari.service.RDatampService;
//import com.sun.jmx.snmp.tasks.ThreadService;
//
//import oracle.net.aso.b;
//
//import static java.lang.Integer.toHexString;
//
//@SuppressWarnings("all")
//@EnableScheduling
//@RestController
//public class RdataController {
//
//    private static Logger log = Logger.getLogger(RdataController.class);
//
//    @Autowired
//    private RDatampService rdatampService;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @RequestMapping("hello")
//    public String hello() throws Exception {
//        // String value = stringRedisTemplate.opsForValue().get("DATA:349779FA_83");
//        // Set<String> keys2 = stringRedisTemplate.keys("DATA:3497775E_*");
//        // System.out.println(keys2 + "输出"); // DATA:34033301_* DATA:34033301_*
//
//        return "访问成功";
//    }
//
//    public static void main(String[] args) {
//        RdataController rdataController = new RdataController();
//        try {
//            rdataController.ThreadService();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    int batch = 0;
//    static String sss = "";
//
//    @RequestMapping("findData")
//    @Async
//    public void ThreadService() throws Exception {
//        String orgNo = "3440101";
//
//        // 查出一个县的供电所 22个供电所
//        List<String> orglist = rdatampService.findByOrgNo(orgNo);
//
//        ExecutorService executors = Executors.newFixedThreadPool(15);
//        if (orglist.size() > 0) {
//            batch = orglist.size() / 15;
//            Thread thread01 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    while (true) {
//                        synchronized (sss) {
//                            try {
//                                System.out.println("线程1执行了");
//                                findDataRedis(0, batch * 1, orglist);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//
//                }
//            });
//
//            Thread thread02 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程2执行了 次");
//                        findDataRedis(batch * 1, batch * 2, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Thread thread03 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程3执行了");
//                        findDataRedis(batch * 2, batch * 4, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Thread thread04 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程4执行了");
//                        findDataRedis(batch * 4, batch * 6, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Thread thread05 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程5执行了");
//                        findDataRedis(batch * 6, batch * 7, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Thread thread06 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程6执行了");
//                        findDataRedis(batch * 7, batch * 8, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread07 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread07执行了");
//                        findDataRedis(batch * 8, batch * 9, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread08 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread08执行了");
//                        findDataRedis(batch * 9, batch * 10, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread09 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread09执行了");
//                        findDataRedis(batch * 10, batch * 13, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread10 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread10执行了");
//                        findDataRedis(batch * 13, batch * 14, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread11 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread11执行了");
//                        findDataRedis(batch * 14, batch * 15, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread12 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread12执行了");
//                        findDataRedis(batch * 15, batch * 17, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread13 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread13执行了");
//                        findDataRedis(batch * 17, batch * 18, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread14 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//
//                        System.out.println("线程thread14执行了");
//                        findDataRedis(batch * 18, batch * 20, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            Thread thread15 = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("线程thread15执行了");
//                        findDataRedis(batch * 20, orglist.size() - 1, orglist);
//
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//            executors.execute(thread01);
//            executors.execute(thread02);
//            executors.execute(thread03);
//            executors.execute(thread04);
//            executors.execute(thread05);
//            executors.execute(thread06);
//
//            executors.execute(thread07);
//            executors.execute(thread08);
//            executors.execute(thread09);
//            executors.execute(thread10);
//            executors.execute(thread11);
//            executors.execute(thread12);
//            executors.execute(thread13);
//            executors.execute(thread14);
//            executors.execute(thread15);
//            executors.shutdown();
//        }
//    }
//
//    // @RequestMapping("findData")
//    public synchronized  void findDataRedis(Integer start, Integer end, List<String> orglist) throws Exception {
//        List<String> neworgList = new ArrayList<>();
//        for (int i = start; i < end; i++) {
//            neworgList.add(orglist.get(i));
//        }
//        JSONObject jsonObject = new JSONObject();
//        long start03 = System.currentTimeMillis();
//        for (String orgnum : neworgList) {
//
//            // 改成根据供电所查出所有的记录
//            List<Rdatamp> rdatampList = rdatampService.findByOrgNoOutList(orgnum);
//
//            // redis中的MPSN list 14842
//            List<String> redisMPSNList = new ArrayList<String>();
//
//            // 装Oracle所有的commaddr
//            List<String> commaddList = new ArrayList<String>(); // rdatampService.findByAddOrCommAddr(addr);
//
//            long start02 = System.currentTimeMillis();
//            // 遍历一个供电所下所有数据
//            for (Rdatamp rdatamp : rdatampList) {
//                // 如果是面向对象的数据
//                if (rdatamp.getProtocolCode().equals("24")) {
//                    // 面向对象数据处理
//                    String adrrOOP = rdatamp.getTerminalAddr();
//                    // 1 根据addr查出Oracle所有的commaddr
//                    List<String> commaddListOOP = rdatampService.findByAddOrCommAddr(adrrOOP);
//                    // 拼成key
//                    String keys = "DATA:" + adrrOOP + "_*";
//                    // Redis中的commaddr地址list
//                    List<String> redisCommaddList = new ArrayList<String>();
//                    Set<String> commaddrkeys = stringRedisTemplate.keys(keys);
//                    for (String commaddrkey : commaddrkeys) {
//                        String commadd = commaddrkey.split("_")[1];
//                        redisCommaddList.add(commadd);
//                    }
//                    for (String commaddr : commaddListOOP) {
//                        // 如果终端地址包含的就比较meterID
//                        if (redisCommaddList.contains(commaddr)) {
//                            String key = "DATA:" + adrrOOP + "_" + commaddr;
//                            String value = stringRedisTemplate.opsForValue().get(key);
//                            JSONObject objectJson = JSONObject.parseObject(value);
//                            Rdatamp rdata = rdatampService.findByAddrandCommaddr(adrrOOP, commaddr);
//                            if (rdata != null && objectJson != null) {
//                                if (!objectJson.getLong("METER_ID").equals(rdata.getMeterId())) {
//                                    String jsonString = "电表信息在Oracle中和Redis都有 具体差异是meiterId不同MeterId数据库是"
//                                            + rdata.getMeterId() + "\r\n" + "电表在Oracle中的终端通讯地址是" + rdata.getCommAddr()
//                                            + "电表在Oracle中的终端地址是" + rdata.getCommAddr() + "电表在Oracle的数据是"
//                                            + rdata.toString() + "\r\n" + "\r\n" + "\r\n" + "电表是Redis的MeterID是"
//                                            + objectJson.getString("METER_ID") + "\r\n" + "具体不一样的字段有" + "终端通讯地址"
//                                            + objectJson.getString("COMM_ADDR") + "tmnlAddr"
//                                            + objectJson.getString("TERMINAL_ADDR") + "\r\n" + objectJson + "\r\n"
//                                            + "\r\n" + "\r\n";
//                                    FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                                }
//                            } else {
//                                String jsonString = "数据为空电表在Oracle中的MeterID是" + rdata.getMeterId()
//                                        + "电表在Oracle中的终端通讯地址是" + rdata.getCommAddr() + "电表在Oracle中的终端地址是"
//                                        + rdata.getCommAddr() + "电表在Oracle的数据是" + rdata.toString() + "\r\n" + "\r\n"
//                                        + "\r\n" + "电表是Redis的MeterID是" + objectJson.getString("METER_ID") + "\r\n"
//                                        + "具体不一样的字段有" + "终端通讯地址" + objectJson.getString("COMM_ADDR") + "tmnlAddr"
//                                        + objectJson.getString("TERMINAL_ADDR") + "\r\n" + objectJson + "\r\n" + "\r\n"
//                                        + "\r\n";
//                                FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                            }
//                        }
//
//                    }
//
//                    // 副本list 用来比较redis和数据库测量点不一样
//                    List<String> list1 = new ArrayList<String>(redisCommaddList); // 去除相同
//                    List<String> list2 = new ArrayList<String>(commaddList);
//                    list1.removeAll(commaddList);//
//                    list2.removeAll(redisCommaddList);//
//                    if (list1.size() > 0) {
//                        // 一个终端下终端通讯地址号redis有 Oracle无
//                        for (String commaddr : list1) {
//
//                            String key = "DATA:" + adrrOOP + "_" + commaddr;
//                            String value = stringRedisTemplate.opsForValue().get(key);
//                            JSONObject objectJson = JSONObject.parseObject(value);
//                            if (objectJson != null) {
//                                // Rdatamp rdata = rdatampService.findByAddrandCommaddr(addr, commaddr);
//                                String jsonString = "终端通讯地址在Redis中有Oracle无----通讯地址为" + objectJson.getString("COMM_ADDR")
//                                        + "电表是Redis的MeterID是" + objectJson.getString("METER_ID") + "\r\n" + "终端地址是"
//                                        + "tmnlAddr" + objectJson.getString("TERMINAL_ADDR") + "\r\n" + objectJson
//                                        + "\r\n" + "\r\n" + "\r\n";
//                                // + "电表在Oracle中的MeterID是" + rdata.getMeterId() + "电表在Oracle中的终端通讯地址是" +
//                                // rdata.getCommAddr()
//                                // + "电表在Oracle中的终端地址是" + rdata.getCommAddr() + "电表在Oracle的数据是" +
//                                // rdata.toString();
//                                FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                            } else {
//                                // log.info("redis中终端地址+测量点号" + rcommaddr + "终端通讯地址：" +
//                                // objectJson.getString("COMM_ADDR") + "查询为null");
//                            }
//                        }
//                    }
//
//                    if (list2.size() > 0) {
//                        // 一个终端下终端通讯地址Oracle有 Redis无
//                        for (String commaddr : list2) {
//                            String key = "DATA:" + adrrOOP + "_" + commaddr;
//                            String value = stringRedisTemplate.opsForValue().get(key);
//                            if (value == null) {
//
//                                Rdatamp rdata = rdatampService.findByAddrandCommaddr(adrrOOP, commaddr);
//                                String jsonString = "电表通信地址在Oracle中有Redis无 终端通讯地址是" + rdata.getCommAddr()
//                                        + "电表在Oracle中的MeterID是" + rdata.getMeterId() + "电表在Oracle中的终端地址是"
//                                        + rdata.getCommAddr() + "电表在Oracle的数据是" + rdata.toString() + "\r\n" + "\r\n"
//                                        + "\r\n";
//                                // + "电表是Redis的MeterID是";
//                                // + objectJson.getString("METER_ID") + "\r\n" + "具体不一样的字段有" + "终端通讯地址"
//                                // + objectJson.getString("COMM_ADDR") + "tmnlAddr" +
//                                // objectJson.getString("TERMINAL_ADDR")
//                                // + "\r\n" + objectJson + "\r\n" + "\r\n" + "\r\n";
//                                FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                            }
//                        }
//                    }
//
//                } else {
//                    // 非面向对象的数据处理
//                    // 获取terminal_addr
//                    String addr = rdatamp.getTerminalAddr();
//                    // 截取终端地址后5位 转换成16进制
//                    String startaddr = addr.substring(0, 4);
//                    int sb5 = Integer.parseInt(addr.substring(4, 9));
//                    String result = toHexString(sb5).toUpperCase();
//                    // 获得16进制的terminal_addr
//                    // String endAddr = "";
//                    if (4 - result.length() != 0) {
//                        result = String.format("%4X", sb5).replaceAll(" ", "0");
//                    }
//                    // 转换成16进制的terminal_addr
//                    String addrH = startaddr + result;
//                    // 获得了terminal_addr就可以模糊查出多个_* 代表测量点号字段
//                    String keys = "DATA:" + addrH + "_*";
//                    // 根据拼好的key模糊查询出多个key
//                    long startkey = System.currentTimeMillis();
//                    Set<String> set = stringRedisTemplate.keys(keys);
//                    long endkey = System.currentTimeMillis();
//                    System.out.println(endkey - startkey + "模糊查询一次keys的时间");
//                    for (String redisAddr : set) {
//                        String value = stringRedisTemplate.opsForValue().get(redisAddr);
//                        JSONObject objectJson = JSONObject.parseObject(value);
//                        String mpsn = redisAddr.split("_")[1];
//                        if (!mpsn.equals("0")) {
//                            redisMPSNList.add(mpsn);
//                        }
//                    }
//
//                    // 根据终端把数据库的测量点号查出来 SQL已经把 测量点号为0过滤掉了
//                    List<String> mpList = rdatampService.findByAddOrMPS(addr);
//                    long start01 = System.currentTimeMillis();
//                    // 比较一个终端下所有的测量点号
//                    for (String omp : mpList) {
//                        if (redisMPSNList.contains(omp)) {
//                            // 如果包含就是同一个终端+mp在Oracle和数据库是一样的继续比较meterID
//                            Rdatamp rdata = rdatampService.findByAddandMP(addr, omp);
//                            // 截取终端地址后5位 转换成16进制
//                            String startaddr1 = addr.substring(0, 4);
//                            int add5 = Integer.parseInt(addr.substring(4, 9));
//                            String result01 = toHexString(add5).toUpperCase();
//                            // 获得16进制的终端地址
//                            if (4 - result01.length() != 0) {
//                                result01 = String.format("%4X", add5).replaceAll(" ", "0");
//                            }
//                            String maddr = startaddr1 + result01;
//                            String key = "DATA:" + maddr + "_" + omp;
//                            String value = stringRedisTemplate.opsForValue().get(key);
//                            JSONObject objectJson = JSONObject.parseObject(value);
//                            if (rdata != null && objectJson != null) {
//                                if (!objectJson.getLong("METER_ID").equals(rdata.getMeterId())) {
//                                    String jsonString = "具体不一样的字段MeterID" + rdata.getMeterId() + "" + "\r\n"
//                                            + "tmnlAddr" + rdata.getTerminalAddr() + "mp_sn" + rdata.getMpSn() + "\r\n"
//                                            + rdata.toString() + "\r\n" + "\r\n" + "电表是Redis的MeterID是"
//                                            + objectJson.getString("METER_ID") + "\r\n" + "具体不一样的字段有" + "MP_SN"
//                                            + objectJson.getString("MP_SN") + "tmnlAddr"
//                                            + objectJson.getString("TERMINAL_ADDR") + "\r\n" + objectJson + "\r\n"
//                                            + "\r\n";
//                                    FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                                } else {
//                                    log.info("redis中终端地址+测量点号" + addrH + "MP：" + omp + "查询为null");
//                                }
//                            }
//                        }
//
//                    }
//                    // ____________________________________
//                    // 副本list 用来比较redis和数据库测量点不一样
//                    List<String> list1 = new ArrayList<String>(redisMPSNList); // 去除相同
//                    List<String> list2 = new ArrayList<String>(mpList);
//                    list1.removeAll(mpList);// mpList和redisMPSNList 比较 相同的去除掉 留下的是数据库多的一部分 差异的一部分数据 Oracle多的
//                    list2.removeAll(redisMPSNList);// 去除掉Redis和数据库都有有的 留下是Redis中多的 就是差异的部分mpsn redis多的
//                    if (list1.size() > 0) {
//                        // 一个终端下测量点号redis有 Oracle无
//                        // 根据终端地址+测量点号查出这条数据打印
//                        for (String rmpn : list1) {
//
//                            // 截取终端地址后5位 转换成16进制
//                            String startaddr2 = addr.substring(0, 4);
//                            int add52 = Integer.parseInt(addr.substring(4, 9));
//                            String result02 = toHexString(add52).toUpperCase();
//                            // 获得16进制的终端地址
//                            if (4 - result02.length() != 0) {
//                                result02 = String.format("%4X", add52).replaceAll(" ", "0");
//                            }
//                            String rddr = startaddr2 + result02;
//                            String key = "DATA:" + rddr + rmpn;
//                            String value = stringRedisTemplate.opsForValue().get(key);
//                            JSONObject objectJson = JSONObject.parseObject(value);
//                            if (objectJson != null) {
//                                // Rdatamp rdata = rdatampService.findByAddandMP(addr,rmpn);
//                                String jsonString = "电表是Redis的MeterID是" + objectJson.getString("METER_ID") + "\r\n"
//                                        + "具体不一样的字段有" + "MP_SN" + objectJson.getString("MP_SN") + "tmnlAddr"
//                                        + objectJson.getString("TERMINAL_ADDR") + "\r\n" + objectJson + "\r\n" + "\r\n";
//                                FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                            } else {
//                                log.info("redis中终端地址+测量点号" + addrH + "MP：" + rmpn + "查询为null");
//                            }
//                        }
//                    }
//
//                    if (list2.size() > 0) {
//                        // 一个终端下测量点号Oracle有 Redis无
//                        for (String Ompn : list2) {
//                            Rdatamp rdata = rdatampService.findByAddandMP(addr, Ompn);
//                            String jsonString = "终端测量点号在Oracle中有Redis无的——————不一样的字段MeterID" + rdata.getMeterId() + ""
//                                    + "\r\n" + "tmnlAddr" + rdata.getTerminalAddr() + "mp_sn" + rdata.getMpSn() + "\r\n"
//                                    + rdata.toString() + "\r\n" + "\r\n" + "\r\n";
//                            FileUtils.write(new File("C://LFF//1.txt"), jsonString, true);
//                        }
//                    }
//
//                }
//                // 终端查询完的结束时间
//            }
//            long end02 = System.currentTimeMillis();
//            System.out.println((end02 - start02) + "" + "——————————————查询一个供电所比较差异的时间");
//        }
//
//        long end03 = System.currentTimeMillis();
//        System.out.println((end03 - start03) + "" + "—————————————查询完一个县的的时间");
//
//        // return "查询完成";
//    }
//
//}
