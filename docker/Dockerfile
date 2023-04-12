FROM mysql:8.0.31
LABEL maintainer="jujin1324@daum.net"
LABEL dockerhub="https://hub.docker.com/_/mysql"

EXPOSE 3399

ADD starter.cnf /etc/mysql/conf.d/
ADD init.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE web_starter
ENV MYSQL_USER spring_web_starter
ENV MYSQL_PASSWORD spring_web_starter
