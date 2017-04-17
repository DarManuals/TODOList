from ubuntu:16.04

RUN apt-get update && \
	apt-get install nginx -y && \
	apt-get install openjdk-8-jdk -y && \
	mkdir -p /var/www/app

COPY app.conf /etc/nginx/sites-available/default
COPY TODOList-0.0.1-SNAPSHOT.jar /opt/app.jar
COPY src/frontend/todolist/build/ /var/www/app/
COPY init.sh /init.sh

RUN chmod +x /init.sh

EXPOSE 80

ENTRYPOINT '/init.sh'
