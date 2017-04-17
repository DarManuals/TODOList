from ubuntu:16.04

RUN apt-get update && apt-get install nginx -y && apt-get install openjdk-8-jdk -y

COPY app.conf /etc/nginx/sites-available/default
COPY TODOList-0.0.1-SNAPSHOT.jar /opt/app.jar
COPY init.sh /init.sh

RUN mkdir -p /var/www/app
COPY src/frontend/todolist/build/ /var/www/app/

RUN chmod +x /init.sh

EXPOSE 80

CMD ["/init.sh"]
