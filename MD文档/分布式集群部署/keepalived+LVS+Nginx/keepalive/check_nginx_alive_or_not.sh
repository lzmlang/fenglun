#!/bin/bash
# 请复制后粘贴到linux中的文件中。不然linux会识别不了windows的一些换行之类的符号
A=$(ps -C nginx --no-header | wc -l)
# 判断nginx是否宕机，如果宕机了，尝试重启
if [ $A -eq 0 ]; then
  sudo /usr/local/nginx/sbin/nginx
  # 等待一小会再次检查nginx，如果没有启动成功，则停止keepalived，使其启动备用机
  sleep 3
  if [ $(ps -C nginx --no-header | wc -l) -eq 0 ]; then
    killall keepalived
  fi
fi
