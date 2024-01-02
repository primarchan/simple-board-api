# Simple-Board-API
- Java, JPA, Spring Boot 기반 게시판 API 

## TECH-STACK
- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- MySQL
- H2 DB
- Gradle
- Lombok
- JUnit5
- IntelliJ IDEA 2022.1.4 (Ultimate Edition)

## REQUIREMENT
- OO

## BUILD & RUN
- OO

## INFRASTRUCTURE
### Docker
- docker-compose.yml
- `docker-compse up -d`

## application.yml
```yml
spring:
  jpa:
    show-sql: true
    properties:
      format_sql: true
      dialect: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: validate
  datasource:
    url: jdbc:mysql://localhost:3307/simple_board?useSSL=false&useUnicode=true&allowPublicKeyRetrieval=true
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ****
    password: ****
```

### docker-compose.yml
```yml
version: "3"
services:
  db:
    image: mysql:8.0.26
    restart: always
    command:
      - --lower_case_table_names=1
      - --character-set-server=utf8mb4
      - --collation-server=utf8mb4_unicode_ci
    container_name: mysql_course3
    ports:
      - "3307:3306"
    environment:
      - MYSQL_DATABASE=****
      - MYSQL_ROOT_PASSWORD=****
      - TZ=Asia/Seoul
#    volumes:
#      - C:\Temp\MYSQL:/var/lib/mysql
```