
#/* Following part is single stage docker building.*/
#FROM eclipse-temurin:17-jdk-jammy
#
#WORKDIR /app
#
#COPY target/*.jar app.jar
#
#EXPOSE 8080
#
#CMD ["java","-jar","app.jar"]

#============================================Single stage docker building end here================================

#=======================Multistage docker building starts here===============================
##Stage 1 ============This stage is build by shri
#FROM maven:3.9.9-eclipse-temurin-17 AS builder
#
#WORKDIR /build
#
#COPY pom.xml .
#RUN mvn dependency:go-offline
#
#COPY src ./src
#
#RUN mvn clean package -DskipTests
#
##Stage 2
#
#FROM eclipse-temurin:17-jdk-jammy
#
#WORKDIR /app
#
#COPY --from=builder /build/target/*.jar app.jar
#
#EXPOSE 8080
#
#CMD ["java","-jar","app.jar"]
#=================================================================================================================

#This stage is build by chatgpt.

# -------- Stage 1: Build --------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests


# -------- Stage 2: Run --------
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]