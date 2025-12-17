# com.ubisam.persons.parkjinwon3

## 1. Maven 프로젝트 + Docker 컨테이너 실행

1. `docker Desktop` 실행

2. `.jar` 파일 생성 명령어 실행
``` bash
.\mvnw clean package -DskipTests 
```

3. `docker-compose` 프로그램 실행
```bash
docker-compose up -d

# DB 결과 확인하려면 DBeaver도 켜야함.
```

## 2. Maven 프로젝트 + Docker 컨테이너 종료
```bash
docker-compose down 
```

