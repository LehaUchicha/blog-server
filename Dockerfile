FROM openjdk:8-jdk-alpine
#VOLUME /tmp
ADD target/blog-server-0.0.1-SNAPSHOT-exec.jar app.jar
RUN echo "export JAVA_HOME=/usr/lib/jvm/java-8-oracle"
#EXPOSE 8080
#ENV JAVA_OPTS=""
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dapp.port=${app.port}", "-jar","/app.jar"]
CMD ["java", "-jar", "app.jar"]