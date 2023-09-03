# SimpleBoard
## SpringBoot와 JPA를 통한 매우간단한 게시판

### 구현 환경
- Project : Gradle-Groovy
- Language : Java 11
- Spring Boot : 2.7.14
- Dependencies
  - Spring Web
  - Lombok
  - Spring Data JPA
  - H2 Database
  - Spring Boot DevTools
  - Thymeleaf
  - Validation
- OS : macOS Ventura 13.4.1
- Tool
  - IntelliJ IDEA
  - H2 Database(1.4.199)
  - Postman

### 구현기능 
- 기본적인 CRUD 기반으로 등록,수정,삭제,조회 기능만 구현(클린코드)
1. 회원 엔티티 CRUD -> 완료
2. 게시판 엔티티 CRUD -> 완료
3. Restful API 통신 -> 완료
4. 로그인/로그아운 구현(Session 이용) -> 작업중
5. 예외처리 구현
6. API 문서 만들기(OpenAPI Swagger)

### 목표
1. API Controller 구현하여 통신
2. 예외처리 기능 추가
3. API 문서 만들어보기
