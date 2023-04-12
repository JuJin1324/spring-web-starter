docker build --tag starter/web-mysql:1.0 .
docker run -d \
-p 3399:3306 \
--name web-starter-mysql \
starter/web-mysql:1.0
