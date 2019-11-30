FROM openjdk:11-jre
COPY ./build/libs/ecommerce-0.0.1-SNAPSHOT.jar /app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /app.jar --debug

