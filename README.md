# 계좌 관리 시스템

## 개요
이 프로젝트는 **Spring Boot**를 기반으로 한 **계좌 관리 시스템**입니다. 계좌 생성, 거래 관리, 데이터 처리 등 다양한 기능을 효율적이고 모듈화된 방식으로 제공합니다.

## 주요 기능
- **계좌 관리**
  - 고유한 계좌 번호로 새로운 계좌 생성
  - 계좌 잔액 및 상태 관리
- **거래 관리**
  - 거래 처리 및 추적
  - 계좌 잔액 업데이트 및 유효성 검증
- **에러 처리**
  - 커스터마이즈된 에러 응답 및 중앙집중식 예외 관리
- **도메인 기반 설계**
  - 확장성과 유지보수성을 고려한 체계적인 구조

## 프로젝트 구조
```plaintext
src
├── main
│   ├── java
│   │   └── com.example.account
│   │       ├── aop                # AOP 기반 락 관리
│   │       ├── config             # 설정 파일 (JPA, Redis 등)
│   │       ├── controller         # 계좌 및 거래 관련 컨트롤러
│   │       ├── domain             # 핵심 엔티티 정의 (계좌, 사용자, 거래)
│   │       ├── dto                # 데이터 전송 객체 (DTO)
│   │       ├── exception          # 예외 처리 클래스
│   │       ├── repository         # Spring Data JPA 리포지토리
│   │       ├── service            # 비즈니스 로직
│   │       └── type               # 열거형 타입 정의 (상태, 에러 코드 등)
│   ├── resources
│   │   ├── application.yml        # 애플리케이션 설정
│   │   ├── data.sql               # 초기 데이터 스크립트
│   │   └── redis-server           # Redis 실행 파일
├── test                           # 테스트 파일
│   ├── controller                 # 컨트롤러 테스트
│   ├── service                    # 서비스 테스트
│   ├── redis                      # Redis 관련 테스트
├── build.gradle                   # 빌드 설정 파일
└── gradlew                        # Gradle 실행 파일

## 주요 컴포넌트

### 컨트롤러
- **AccountController**  
  계좌 관련 HTTP 요청 처리
- **TransactionController**  
  거래 관련 엔드포인트 관리

### 서비스
- **AccountService**  
  - 계좌 생성 및 관리의 핵심 비즈니스 로직
  - 유효성 검사 및 에러 처리 포함
- **TransactionService**  
  - 거래 기록 및 처리를 담당

### DTO (데이터 전송 객체)
- **AccountDto**  
  계좌 데이터를 외부로 전달하기 위한 객체
- **TransactionDto**  
  거래 데이터를 위한 객체

### 리포지토리
- **AccountRepository**
- **AccountUserRepository**
- **TransactionRepository**

### AOP
- **AccountLock**  
  거래 도중 데이터 동시성을 보장하는 AOP 기반 락 구현

## 요구 사항

- **Java 11** 이상
- **Spring Boot 2.5+**
- **Gradle** 빌드 시스템
- **데이터베이스**: 기본적으로 H2 사용 (MySQL 등으로 변경 가능)
- **Redis**: 임베디드 Redis 사용  
  - M1 MacBook 환경에서 Redis를 직접 빌드하여 사용


---

## 향후 개선 사항

- 사용자 인증 및 권한 관리 추가
- 주요 작업에 대한 감사 로그(Audit Log) 구현
- 거래 보고서 및 분석 기능 강화


1. **프로젝트를 클론합니다.**
   ```bash
   git clone https://github.com/사용자이름/account-management-system.git

