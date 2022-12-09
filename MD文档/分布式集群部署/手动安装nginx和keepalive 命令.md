(1)安装gcc环境
yum install gcc-c++
(2)安装PCRE库，用于解析正则表达式
yum install -y pcre pcre-devel
(3)zlib压缩和解压缩依赖，
yum install -y zlib zlib-devel
(4)SSL 安全的加密的套接字协议层，用于HTTP安全传输，也就是https
yum install -y openssl openssl-devel

4. 解压，需要注意，解压后得到的是源码，源码需要编译后才能安装
tar -zxvf nginx-1.16.1.tar.gz
5. 编译之前，先创建nginx临时目录，如果不创建，在启动nginx的过程中会报错
mkdir /var/temp/nginx -p
6. 在nginx目录，输入如下命令进行配置，目的是为了创建makefile文件
./configure \
--prefix=/usr/local/nginx \
--pid-path=/var/run/nginx/nginx.pid \
--lock-path=/var/lock/nginx.lock \
--error-log-path=/var/log/nginx/error.log \
--http-log-path=/var/log/nginx/access.log \
--with-http_gzip_static_module \
--http-client-body-temp-path=/var/temp/nginx/client \
--http-proxy-temp-path=/var/temp/nginx/proxy \
--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
--http-scgi-temp-path=/var/temp/nginx/scgi
7. make编译：make
8. 安装：make install
9. 进入sbin目录启动nginx
注意 如果安装完后出现nginx命名不可用记得在/etc/profile中添加nginx的启动路径
export PATH=$PATH:/usr/local/nginx/sbin
keepalive的安装
前面部分是一样的
yum -y install libnl libnl-devel
./configure \
--prefix=/usr/local/keepalived \
--sysconf=/etc