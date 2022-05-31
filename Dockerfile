FROM openjdk:11-jre
COPY target/staying-organized.jar /myapp.jar
ENTRYPOINT [ "java", "-jar", "/myapp.jar" ]