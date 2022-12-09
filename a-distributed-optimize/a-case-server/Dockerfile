FROM openjdk:8-jdk-alpine
EXPOSE 9102 
VOLUME /app
WORKDIR /app
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
ADD eic-team-service.jar /app/eic-team-service.jar
ENTRYPOINT exec java  -Xmx768m -Xms256m -Duser.timezone=GMT+08  -jar /app/eic-team-service.jar --spring.profiles.active=dev-k8s
