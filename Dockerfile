FROM openjdk:8
ADD target/ProductServiceApp-0.0.1-SNAPSHOT.jar ProductServiceApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ProductServiceApp.jar"]