FROM java:8

COPY app.jar /opt/app.jar
COPY init.sh /init.sh

RUN chmod +x /init.sh

EXPOSE 8080

CMD ["/init.sh"]

