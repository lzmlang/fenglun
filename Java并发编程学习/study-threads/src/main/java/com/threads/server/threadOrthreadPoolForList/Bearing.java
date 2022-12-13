//package com.threads.server.threadOrthreadPoolForList;
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//
//import java.util.ArrayList;
//import java.util.concurrent.*;
//
///**Callable和Future的联合使用
// * @author 罗泽民
// * @description
// * @date 2021/1/8 0:11
// */
//public class Bearing {
//    public void method(){
//        //计算数据获取,计划开工时间计算承载力,这里需要把时间参数传进来
//        List<Callable<List<BearerConstructionDTO>>> callableList = new ArrayList<>();
//        for (BearerConsUnitNameDTO bearerConsUnitNameDTO : data) {
//            List<BearerConsUnitNameDTO> dtoArrayList = new ArrayList<>(1);
//            dtoArrayList.add(bearerConsUnitNameDTO);
//            Callable<List<BearerConstructionDTO>> callable = new CsBearingThreadTask(dtoArrayList, umsBearingCsMapper, queryData);
//            callableList.add(callable);
//        }
//        //ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thead-cs-Bearing-%d").build();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(), threadFactory);
//        List<Future<List<BearerConstructionDTO>>> futureList = null;
//
//        try {
//
//            futureList = executor.invokeAll(callableList);
//        } catch (InterruptedException e) {
//            throw new NcException("承载力计算出错");
//        } finally {
//            executor.shutdown();
//        }
//        //设置数据是否过期标识
//        stringRedisUtil.set(FLAG_TIME_OUT, FLAG_TIME_OUT, BEARING_TIME_OUT);
//        futureList.stream().forEach(e -> {
//            try {
//                List<BearerConstructionDTO> bearerConstructionDTOS = e.get();
//                //放到redis
//                stringRedisUtil.set(CS_BEARING + bearerConstructionDTOS.get(0).getId(), JSONObject.toJSONString(bearerConstructionDTOS.get(0)), BEARING_TIME_OUT);
//                calculationData.addAll(bearerConstructionDTOS);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            } catch (ExecutionException ex) {
//                ex.printStackTrace();
//            }
//        });
//        System.out.println(Thread.currentThread().getName() + "执行" + data.size() + "个公司承载力完毕。耗时:" + (System.currentTimeMillis() - start));
//    }
//}
