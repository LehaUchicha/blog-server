FROM maven:3.6.2-jdk-8
ENV application_dir /usr/app
WORKDIR ${application_dir}
COPY ./pom.xml ./
RUN mvn clean install -DskipTests=true
COPY ./ ./
#ADD /root/.m2/repository/ru/alexproject/blog-server/0.0.1-SNAPSHOT/blog-server-0.0.1-SNAPSHOT-exec.jar ${application_dir}/target/app.jar
EXPOSE 8090
CMD ["mvn", "spring-boot:run"]