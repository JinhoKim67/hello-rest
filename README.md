## 1. Maven 프로젝트 + Docker 컨테이너 실행

1. `docker Desktop` 실행

2. 터미널에서 Docker 실행 (**버전은 이미지 마다 다를 수 있음.**)
```bash
# MySQL
docker pull mysql:9.5.0
## 컨테이너 실행 (c:\yourdata에 Docker내 /var/lib/postgresql/data 폴더를 마운트함)
docker run --name=mydata -p 3306:3306 -v C:/yourdata:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=docker123 -d mysql:9.5.0
```
```bash
# PostgreSQL
docker pull postgres:latest
## 컨테이너 실행 (c:\yourdata에 Docker내 /var/lib/postgresql/data 폴더를 마운트함)
docker run --name postgres-db -p 5432:5432 -v C:/yourdata:/var/lib/postgresql/data -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=rest -d postgres:latest
``` 
```bash
# MSSQL
docker pull mcr.microsoft.com/mssql/server:2025-latest
## 컨테이너 실행 (c:\yourdata에 Docker내 /var/lib/postgresql/data 폴더를 마운트함)
docker run -d --name mssql -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=msSQL1234!" -p 14330:1433 -v C:\workspace\hello-docker\backup:/var/opt/mssql/backup ` mcr.microsoft.com/mssql/server:2022-latest
## BackUp 파일 만들기
docker exec -it mssql /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "msSQL1234!" -Q "BACKUP DATABASE [MyDb] TO DISK = N'/var/opt/mssql/backup/MyDb.bak' WITH INIT, COMPRESSION" -C
## BackUp 파일 Restore
docker exec -it mssql /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "msSQL1234!" -C -Q "RESTORE DATABASE [MyDb] FROM DISK = N'/var/opt/mssql/backup/MyDb.bak' WITH MOVE N'MyDb' TO N'/var/opt/mssql/data/MyDb.mdf', MOVE N'MyDb_log' TO N'/var/opt/mssql/data/MyDb_log.ldf', REPLACE, RECOVERY;"
```

3. 터미널에서 Spring Boot 애플리케이션 실행
```bash
# test 폴더에서는 '>' 화살표 클릭과 동일함.
.\mvnw spring-boot:run
```