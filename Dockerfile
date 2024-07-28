FROM openjdk:22
WORKDIR /app
COPY /out/artifacts/RestServiceServlet_jar/RestServiceServlet.jar /app/servlet.jar
CMD ["java", "-jar", "servlet.jar"]