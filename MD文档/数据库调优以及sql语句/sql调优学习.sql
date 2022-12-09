-- 开启慢查询的一些日志
set global slow_query_log = 'on';
set global log_output = 'FILE,TABLE';
set global long_query_time = 0.001;
SHOW VARIABLES LIKE 'long_query_time%';
-- 记录没有走索引的查询
set global log_queries_not_using_indexes = 'ON';

select * from employees;
select * from mysql.slow_log;
-- 文件中的慢查询日志
SHOW VARIABLES LIKE '%slow_query_log%';

explain format = tree select * from salaries where salary=1;
explain
-- format = json
select * from salaries where salary = 1;
select * from employees e left join salaries s on e.emp_no = s.emp_no where e.emp_no=10001;
select * from employees where emp_no=10001;
show warnings;-- 这个mysql的client中先执行explain后在执行show warnings

 -- 更加细致的sql分析
 -- 1.show profile
select  @@have_profiling;-- 是否支持show profiles功能
select @@profiling;-- 是否开启
set @@profiling=1;-- 开启功能
set profiling_history_size =100; -- 修改 记录的大小
show profiles;
-- 查看某一条sql的时间开销
show profile all for query 46;
set @@profiling=0;-- 使用完毕后关闭功能
-- 2.information_schema.profiling
-- 下面两条sql的功能是一样的.
show profile for query 46;
SELECT STATE,FORMAT(DURATION,6) AS DURATION FROM INFORMATION_SCHEMA.PROFILING WHERE QUERY_ID= 373 ORDER BY SEQ;

-- 3.performance_schema
select * from performance_schema.setup_actors;
-- 监控项开启
update performance_schema.setup_instruments set ENABLED='YES',TIMED='YES' where NAME like '%statement/%';
update performance_schema.setup_instruments set ENABLED='YES',TIMED='YES' where NAME like '%stage/%';
update performance_schema.setup_consumers set ENABLED='YES' where NAME like '%events_statements_%';
update performance_schema.setup_consumers set ENABLED='YES' where NAME like '%events_stages_%';
-- 获得语句的event_id
select EVENT_ID,truncate(TIMER_WAIT/1000000000000,6) as duration,SQL_TEXT from performance_schema.events_statements_history_long where SQL_TEXT like '%salaries%';
-- 查看执行时间
select EVENT_NAME as stage ,truncate(TIMER_WAIT/1000000000000,6) as duration from performance_schema.events_stages_history_long where NESTING_EVENT_ID =1248;


