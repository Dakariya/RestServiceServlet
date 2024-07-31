FROM tomcat:9.0.91
WORKDIR /src/app
COPY /target/untitled6.war /src/app
EXPOSE 8080
CMD ["catalina.sh", "run"]