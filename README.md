## 1. Maven 프로젝트 + Docker 컨테이너 실행

1. `docker Desktop` 실행

2. 터미널에서 Docker 실행 (**버전은 이미지 마다 다를 수 있음.**)
```bash
# MySQL
docker pull mysql:9.5.0
# 컨테이너 실행 (C:/workspace/docker/mySqldata에 Docker내 /var/lib/postgresql/data 폴더를 마운트함)
docker run --name=mysqldata -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -v C:/workspace/docker/mySqldata:/var/lib/mysql -d mysql:9.5.0

```
```bash
# PostgreSQL
docker pull postgres:latest
# 컨테이너 실행 (C:/workspace/docker/pgdata18에 Docker내 /var/lib/postgresql 폴더를 마운트함)
docker run --name=postgresdata -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=myPGdb -v C:/workspace/docker/pgdata18:/var/lib/postgresql -d postgres:18

``` 
```bash
# MSSQL
docker pull mcr.microsoft.com/mssql/server:2025-latest
# 컨테이너 실행 (C:/workspace/docker/mssql/data에 Docker내 /var/opt/mssql/data 폴더를 마운트함)
docker run --name mssqldata -p 14330:1433 -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=MyStrong@Pass123" -v C:/workspace/docker/mssql/data:/var/opt/mssql/data -d mcr.microsoft.com/mssql/server:2022-latest

```

3. 터미널에서 Spring Boot 애플리케이션 실행
```bash
# test 폴더에서는 '>' 화살표 클릭과 동일함.
.\mvnw spring-boot:run
```